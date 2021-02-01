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
/* loaded from: classes11.dex */
public class j implements AbsListView.OnScrollListener, d.a {
    private c bLb;
    private AlbumActivity bLp;
    private View bLs;
    private TextView bLt;
    private TextView bLu;
    private MediaStoreLoader bMc;
    private RelativeLayout bMd;
    private ImageView bMe;
    private TextView bMf;
    private TextView bMg;
    private com.baidu.live.tieba.write.a.a bMh;
    private TransparentHeadGridView bMi;
    private i bMj;
    private CommonEmptyView bMk;
    private View bMl;
    private View bMm;
    private boolean isPaused;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bMn = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bLb != null) {
                if (view == j.this.bMg) {
                    j.this.bMh.setData(j.this.bLb.UK(), j.this.bLb.UI());
                    j.this.bMh.O(j.this.bMl);
                    j.this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bLs) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bMg != null) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bMg.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bLV = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bLb != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bLb.d((ImageFileInfo) mediaFileInfo);
                    j.this.bLp.eP(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0218a bMo = new a.InterfaceC0218a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0218a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hV;
            if (j.this.bLb != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bLb.UI()) && (hV = j.this.bLb.hV(albumId)) != null) {
                    j.this.bLb.hT(albumId);
                    j.this.bMj.setData(hV);
                    if (j.this.bMj.getCount() <= 0) {
                        j.this.bMk.setVisibility(0);
                    } else {
                        j.this.bMk.setVisibility(8);
                    }
                    j.this.bMg.setText(name);
                    j.this.bMi.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bLW = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bLp == null || j.this.bLb == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bLb.UE()) {
                    j.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bLb.isAdded(imageFileInfo)) {
                    j.this.bLp.b(imageFileInfo);
                } else {
                    j.this.bLp.a(imageFileInfo);
                }
                j.this.bLb.a((VideoFileInfo) null);
                j.this.bMj.notifyDataSetChanged();
                j.this.UO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bLb.UD()) {
                    j.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bLb.b(videoFileInfo)) {
                        j.this.bLb.a((VideoFileInfo) null);
                    } else {
                        j.this.bLb.a(videoFileInfo);
                    }
                    j.this.bLb.UF();
                    j.this.bMj.notifyDataSetChanged();
                    j.this.UO();
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
        this.bLp = albumActivity;
        this.bLb = this.bLp.Uo();
        d.UL().a(this);
        this.bMc = new MediaStoreLoader(this.bLp);
        this.bMh = new com.baidu.live.tieba.write.a.a(this.bLp);
        this.bMh.setOnDismissListener(this.mOnDismissListener);
        this.bMh.a(this.bMo);
        initView();
    }

    public final View initView() {
        this.mView = LayoutInflater.from(this.bLp).inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bMd = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bMl = this.mView.findViewById(a.f.layout_title);
        this.bMg = (TextView) this.mView.findViewById(a.f.album_title);
        this.bMe = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bMf = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bMm = this.mView.findViewById(a.f.navi_line);
        this.bLs = this.mView.findViewById(a.f.layout_bottom);
        this.bLu = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bLt = (TextView) this.mView.findViewById(a.f.next_step);
        this.bLb.hT(AlbumData.ALBUM_ID_ALL);
        this.bMg.setText(this.bLp.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bMk = new CommonEmptyView(this.bLp);
        this.bMk.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bMk.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bMk.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bMk.setVisibility(8);
        this.bMk.addToParent(this.bMd);
        this.bMi = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bMi.setSelector(a.c.sdk_transparent);
        this.bMj = new i(this.bLp, this.bLb);
        this.bMi.setAdapter((ListAdapter) this.bMj);
        this.bMi.setOuterOnScrollListener(this);
        this.bMj.a(this.bLW);
        this.bMj.a(this.bLV);
        this.bLt.setOnClickListener(this.bLp);
        this.bMe.setOnClickListener(this.bLp);
        this.bMf.setOnClickListener(this.bLp);
        this.bLu.setOnClickListener(this.bLp);
        this.bMg.setOnClickListener(this.mOnClickListener);
        this.bLs.setOnClickListener(this.mOnClickListener);
        UO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bMn == null) {
            this.bMn = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bMn.setCancelListener(null);
        this.bMn.setTipString(a.h.sdk_loading);
        this.bMn.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bLp.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        int count;
        String string;
        if (this.bLb != null && this.bLt != null) {
            if (this.bLb.UE()) {
                int i = this.bLb.UE() ? 1 : 0;
                string = this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bLb.UG());
                string = this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bLb.getMaxImagesAllowed())});
            }
            this.bLt.setText(string);
            this.bLt.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.isPaused = false;
        Ut();
    }

    private void Us() {
        if (this.bLb == null && this.bLp != null) {
            this.bLb = this.bLp.Uo();
        }
        if (this.bLb != null) {
            UP();
            dn(this.bLb.isOriginalImg());
        }
    }

    private void UP() {
        if (this.bMc == null) {
            this.bMc = new MediaStoreLoader(this.bLp);
        }
        this.bMc.loadAll(this.bLp.Un() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bMn != null) {
                    j.this.bMn.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bLb != null && resutMediaStore != null) {
                    j.this.bLb.a(resutMediaStore);
                    String UI = j.this.bLb.UI();
                    j.this.bLb.hT(UI);
                    j.this.bMj.setData(j.this.bLb.hV(UI));
                    if (j.this.bMj.getCount() <= 0) {
                        j.this.bMk.setVisibility(0);
                    } else {
                        j.this.bMk.setVisibility(8);
                    }
                    j.this.bMi.smoothScrollToPosition(0);
                    j.this.UO();
                }
                j.this.bMi.UR();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bMm, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bMg, a.c.sdk_cp_cont_b, i);
        if (this.bLp.Un() == 1) {
            SkinManager.setImageResource(this.bMe, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bMf.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bMf, a.c.sdk_ph_navi_back_text_color);
            this.bMe.setVisibility(8);
        }
        if (this.bMg != null) {
            this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bMj != null) {
            this.bMj.notifyDataSetChanged();
        }
        if (this.bLb != null) {
            dn(this.bLb.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View UM() {
        return this.bLp.Un() == 1 ? this.bMe : this.bMf;
    }

    public View UQ() {
        return this.bLt;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dp(boolean z) {
        Ut();
    }

    private void Ut() {
        if (!this.isPaused) {
            Us();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bMj.dq(true);
        } else if (this.bMj.isScroll()) {
            this.bMj.dq(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bMi != null) {
            int firstVisiblePosition = this.bMi.getFirstVisiblePosition();
            int lastVisiblePosition = this.bMi.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bMi.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bMj != null) {
                    this.bMj.b((ImageView) childAt.findViewById(a.f.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        UO();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bMj != null) {
            o(this.bMj.e(imageFileInfo), z);
        }
    }

    public View Uz() {
        return this.bLu;
    }

    public void dn(boolean z) {
        if (this.bLp != null && this.bLu != null) {
            this.bLu.setText(this.bLp.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_cont_f);
        }
    }
}
