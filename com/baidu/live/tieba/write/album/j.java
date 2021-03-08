package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.MediaStoreLoadCallback;
import com.baidu.live.tbadk.album.MediaStoreLoader;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.write.a.a;
import com.baidu.live.tieba.write.album.d;
import java.util.List;
/* loaded from: classes10.dex */
public class j implements AbsListView.OnScrollListener, d.a {
    private c bMB;
    private AlbumActivity bMP;
    private View bMS;
    private TextView bMT;
    private TextView bMU;
    private MediaStoreLoader bNC;
    private RelativeLayout bND;
    private ImageView bNE;
    private TextView bNF;
    private TextView bNG;
    private com.baidu.live.tieba.write.a.a bNH;
    private TransparentHeadGridView bNI;
    private i bNJ;
    private CommonEmptyView bNK;
    private View bNL;
    private View bNM;
    private boolean isPaused;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bNN = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bMB != null) {
                if (view == j.this.bNG) {
                    j.this.bNH.setData(j.this.bMB.UN(), j.this.bMB.UL());
                    j.this.bNH.O(j.this.bNL);
                    j.this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bMS) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bNG != null) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bNG.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bNv = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bMB != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bMB.d((ImageFileInfo) mediaFileInfo);
                    j.this.bMP.eQ(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0224a bNO = new a.InterfaceC0224a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0224a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ib;
            if (j.this.bMB != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bMB.UL()) && (ib = j.this.bMB.ib(albumId)) != null) {
                    j.this.bMB.hZ(albumId);
                    j.this.bNJ.setData(ib);
                    if (j.this.bNJ.getCount() <= 0) {
                        j.this.bNK.setVisibility(0);
                    } else {
                        j.this.bNK.setVisibility(8);
                    }
                    j.this.bNG.setText(name);
                    j.this.bNI.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bNw = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bMP == null || j.this.bMB == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bMB.UH()) {
                    j.this.bMP.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bMB.isAdded(imageFileInfo)) {
                    j.this.bMP.b(imageFileInfo);
                } else {
                    j.this.bMP.a(imageFileInfo);
                }
                j.this.bMB.a((VideoFileInfo) null);
                j.this.bNJ.notifyDataSetChanged();
                j.this.UR();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bMB.UG()) {
                    j.this.bMP.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bMB.b(videoFileInfo)) {
                        j.this.bMB.a((VideoFileInfo) null);
                    } else {
                        j.this.bMB.a(videoFileInfo);
                    }
                    j.this.bMB.UI();
                    j.this.bNJ.notifyDataSetChanged();
                    j.this.UR();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    public j(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.bMP = albumActivity;
        this.bMB = this.bMP.Ur();
        d.UO().a(this);
        this.bNC = new MediaStoreLoader(this.bMP);
        this.bNH = new com.baidu.live.tieba.write.a.a(this.bMP);
        this.bNH.setOnDismissListener(this.mOnDismissListener);
        this.bNH.a(this.bNO);
        initView();
    }

    public final View initView() {
        this.mView = LayoutInflater.from(this.bMP).inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bND = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bNL = this.mView.findViewById(a.f.layout_title);
        this.bNG = (TextView) this.mView.findViewById(a.f.album_title);
        this.bNE = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bNF = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bNM = this.mView.findViewById(a.f.navi_line);
        this.bMS = this.mView.findViewById(a.f.layout_bottom);
        this.bMU = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bMT = (TextView) this.mView.findViewById(a.f.next_step);
        this.bMB.hZ(AlbumData.ALBUM_ID_ALL);
        this.bNG.setText(this.bMP.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bNK = new CommonEmptyView(this.bMP);
        this.bNK.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bNK.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bNK.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bNK.setVisibility(8);
        this.bNK.addToParent(this.bND);
        this.bNI = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bNI.setSelector(a.c.sdk_transparent);
        this.bNJ = new i(this.bMP, this.bMB);
        this.bNI.setAdapter((ListAdapter) this.bNJ);
        this.bNI.setOuterOnScrollListener(this);
        this.bNJ.a(this.bNw);
        this.bNJ.a(this.bNv);
        this.bMT.setOnClickListener(this.bMP);
        this.bNE.setOnClickListener(this.bMP);
        this.bNF.setOnClickListener(this.bMP);
        this.bMU.setOnClickListener(this.bMP);
        this.bNG.setOnClickListener(this.mOnClickListener);
        this.bMS.setOnClickListener(this.mOnClickListener);
        UR();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bNN == null) {
            this.bNN = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bNN.setCancelListener(null);
        this.bNN.setTipString(a.h.sdk_loading);
        this.bNN.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bMP.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        int count;
        String string;
        if (this.bMB != null && this.bMT != null) {
            if (this.bMB.UH()) {
                int i = this.bMB.UH() ? 1 : 0;
                string = this.bMP.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bMB.UJ());
                string = this.bMP.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMB.getMaxImagesAllowed())});
            }
            this.bMT.setText(string);
            this.bMT.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.isPaused = false;
        Uw();
    }

    private void Uv() {
        if (this.bMB == null && this.bMP != null) {
            this.bMB = this.bMP.Ur();
        }
        if (this.bMB != null) {
            US();
            dn(this.bMB.isOriginalImg());
        }
    }

    private void US() {
        if (this.bNC == null) {
            this.bNC = new MediaStoreLoader(this.bMP);
        }
        this.bNC.loadAll(this.bMP.Uq() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bNN != null) {
                    j.this.bNN.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bMB != null && resutMediaStore != null) {
                    j.this.bMB.a(resutMediaStore);
                    String UL = j.this.bMB.UL();
                    j.this.bMB.hZ(UL);
                    j.this.bNJ.setData(j.this.bMB.ib(UL));
                    if (j.this.bNJ.getCount() <= 0) {
                        j.this.bNK.setVisibility(0);
                    } else {
                        j.this.bNK.setVisibility(8);
                    }
                    j.this.bNI.smoothScrollToPosition(0);
                    j.this.UR();
                }
                j.this.bNI.UU();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bNM, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bNG, a.c.sdk_cp_cont_b, i);
        if (this.bMP.Uq() == 1) {
            SkinManager.setImageResource(this.bNE, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bNF.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bNF, a.c.sdk_ph_navi_back_text_color);
            this.bNE.setVisibility(8);
        }
        if (this.bNG != null) {
            this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bNJ != null) {
            this.bNJ.notifyDataSetChanged();
        }
        if (this.bMB != null) {
            dn(this.bMB.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View UP() {
        return this.bMP.Uq() == 1 ? this.bNE : this.bNF;
    }

    public View UT() {
        return this.bMT;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dp(boolean z) {
        Uw();
    }

    private void Uw() {
        if (!this.isPaused) {
            Uv();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bNJ.dq(true);
        } else if (this.bNJ.isScroll()) {
            this.bNJ.dq(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bNI != null) {
            int firstVisiblePosition = this.bNI.getFirstVisiblePosition();
            int lastVisiblePosition = this.bNI.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bNI.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bNJ != null) {
                    this.bNJ.b((ImageView) childAt.findViewById(a.f.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        UR();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bNJ != null) {
            o(this.bNJ.e(imageFileInfo), z);
        }
    }

    public View UC() {
        return this.bMU;
    }

    public void dn(boolean z) {
        if (this.bMP != null && this.bMU != null) {
            this.bMU.setText(this.bMP.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_cont_f);
        }
    }
}
