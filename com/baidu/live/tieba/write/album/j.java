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
    private AlbumActivity bHF;
    private View bHI;
    private TextView bHJ;
    private TextView bHK;
    private c bHr;
    private CommonEmptyView bIA;
    private View bIB;
    private View bIC;
    private MediaStoreLoader bIs;
    private RelativeLayout bIt;
    private ImageView bIu;
    private TextView bIv;
    private TextView bIw;
    private com.baidu.live.tieba.write.a.a bIx;
    private TransparentHeadGridView bIy;
    private i bIz;
    private boolean isPaused;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bID = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bHr != null) {
                if (view == j.this.bIw) {
                    j.this.bIx.c(j.this.bHr.Td(), j.this.bHr.Tb());
                    j.this.bIx.O(j.this.bIB);
                    j.this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bHI) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bIw != null) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bIw.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bIl = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bHr != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bHr.d((ImageFileInfo) mediaFileInfo);
                    j.this.bHF.eL(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0216a bIE = new a.InterfaceC0216a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0216a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hz;
            if (j.this.bHr != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bHr.Tb()) && (hz = j.this.bHr.hz(albumId)) != null) {
                    j.this.bHr.hx(albumId);
                    j.this.bIz.setData(hz);
                    if (j.this.bIz.getCount() <= 0) {
                        j.this.bIA.setVisibility(0);
                    } else {
                        j.this.bIA.setVisibility(8);
                    }
                    j.this.bIw.setText(name);
                    j.this.bIy.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bIm = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bHF == null || j.this.bHr == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bHr.SX()) {
                    j.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bHr.isAdded(imageFileInfo)) {
                    j.this.bHF.b(imageFileInfo);
                } else {
                    j.this.bHF.a(imageFileInfo);
                }
                j.this.bHr.a((VideoFileInfo) null);
                j.this.bIz.notifyDataSetChanged();
                j.this.Th();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bHr.SW()) {
                    j.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bHr.b(videoFileInfo)) {
                        j.this.bHr.a((VideoFileInfo) null);
                    } else {
                        j.this.bHr.a(videoFileInfo);
                    }
                    j.this.bHr.SY();
                    j.this.bIz.notifyDataSetChanged();
                    j.this.Th();
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
        this.bHF = albumActivity;
        this.bHr = this.bHF.SH();
        d.Te().a(this);
        this.bIs = new MediaStoreLoader(this.bHF);
        this.bIx = new com.baidu.live.tieba.write.a.a(this.bHF);
        this.bIx.setOnDismissListener(this.mOnDismissListener);
        this.bIx.a(this.bIE);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.bHF).inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bIt = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bIB = this.mView.findViewById(a.f.layout_title);
        this.bIw = (TextView) this.mView.findViewById(a.f.album_title);
        this.bIu = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bIv = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bIC = this.mView.findViewById(a.f.navi_line);
        this.bHI = this.mView.findViewById(a.f.layout_bottom);
        this.bHK = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bHJ = (TextView) this.mView.findViewById(a.f.next_step);
        this.bHr.hx(AlbumData.ALBUM_ID_ALL);
        this.bIw.setText(this.bHF.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bIA = new CommonEmptyView(this.bHF);
        this.bIA.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bIA.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bIA.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bIA.setVisibility(8);
        this.bIA.addToParent(this.bIt);
        this.bIy = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bIy.setSelector(a.c.sdk_transparent);
        this.bIz = new i(this.bHF, this.bHr);
        this.bIy.setAdapter((ListAdapter) this.bIz);
        this.bIy.setOuterOnScrollListener(this);
        this.bIz.a(this.bIm);
        this.bIz.a(this.bIl);
        this.bHJ.setOnClickListener(this.bHF);
        this.bIu.setOnClickListener(this.bHF);
        this.bIv.setOnClickListener(this.bHF);
        this.bHK.setOnClickListener(this.bHF);
        this.bIw.setOnClickListener(this.mOnClickListener);
        this.bHI.setOnClickListener(this.mOnClickListener);
        Th();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bID == null) {
            this.bID = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bID.setCancelListener(null);
        this.bID.setTipString(a.h.sdk_loading);
        this.bID.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bHF.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        int count;
        String string;
        if (this.bHr != null && this.bHJ != null) {
            if (this.bHr.SX()) {
                int i = this.bHr.SX() ? 1 : 0;
                string = this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bHr.SZ());
                string = this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHr.getMaxImagesAllowed())});
            }
            this.bHJ.setText(string);
            this.bHJ.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.isPaused = false;
        SM();
    }

    private void SL() {
        if (this.bHr == null && this.bHF != null) {
            this.bHr = this.bHF.SH();
        }
        if (this.bHr != null) {
            Ti();
            df(this.bHr.isOriginalImg());
        }
    }

    private void Ti() {
        if (this.bIs == null) {
            this.bIs = new MediaStoreLoader(this.bHF);
        }
        this.bIs.loadAll(this.bHF.SG() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bID != null) {
                    j.this.bID.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bHr != null && resutMediaStore != null) {
                    j.this.bHr.a(resutMediaStore);
                    String Tb = j.this.bHr.Tb();
                    j.this.bHr.hx(Tb);
                    j.this.bIz.setData(j.this.bHr.hz(Tb));
                    if (j.this.bIz.getCount() <= 0) {
                        j.this.bIA.setVisibility(0);
                    } else {
                        j.this.bIA.setVisibility(8);
                    }
                    j.this.bIy.smoothScrollToPosition(0);
                    j.this.Th();
                }
                j.this.bIy.Tk();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bIC, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bIw, a.c.sdk_cp_cont_b, i);
        if (this.bHF.SG() == 1) {
            SkinManager.setImageResource(this.bIu, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bIv.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bIv, a.c.sdk_ph_navi_back_text_color);
            this.bIu.setVisibility(8);
        }
        if (this.bIw != null) {
            this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bIz != null) {
            this.bIz.notifyDataSetChanged();
        }
        if (this.bHr != null) {
            df(this.bHr.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View Tf() {
        return this.bHF.SG() == 1 ? this.bIu : this.bIv;
    }

    public View Tj() {
        return this.bHJ;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dh(boolean z) {
        SM();
    }

    private void SM() {
        if (!this.isPaused) {
            SL();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bIz.di(true);
        } else if (this.bIz.isScroll()) {
            this.bIz.di(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bIy != null) {
            int firstVisiblePosition = this.bIy.getFirstVisiblePosition();
            int lastVisiblePosition = this.bIy.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bIy.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bIz != null) {
                    this.bIz.b((ImageView) childAt.findViewById(a.f.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Th();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bIz != null) {
            o(this.bIz.e(imageFileInfo), z);
        }
    }

    public View SS() {
        return this.bHK;
    }

    public void df(boolean z) {
        if (this.bHF != null && this.bHK != null) {
            this.bHK.setText(this.bHF.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_cont_f);
        }
    }
}
