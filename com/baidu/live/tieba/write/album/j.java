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
    private c bMd;
    private AlbumActivity bMr;
    private View bMu;
    private TextView bMv;
    private TextView bMw;
    private MediaStoreLoader bNe;
    private RelativeLayout bNf;
    private ImageView bNg;
    private TextView bNh;
    private TextView bNi;
    private com.baidu.live.tieba.write.a.a bNj;
    private TransparentHeadGridView bNk;
    private i bNl;
    private CommonEmptyView bNm;
    private View bNn;
    private View bNo;
    private boolean isPaused;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bNp = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bMd != null) {
                if (view == j.this.bNi) {
                    j.this.bNj.c(j.this.bMd.WV(), j.this.bMd.WT());
                    j.this.bNj.O(j.this.bNn);
                    j.this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bMu) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bNi != null) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bNi.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bMX = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bMd != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bMd.d((ImageFileInfo) mediaFileInfo);
                    j.this.bMr.gs(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0225a bNq = new a.InterfaceC0225a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0225a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> iK;
            if (j.this.bMd != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bMd.WT()) && (iK = j.this.bMd.iK(albumId)) != null) {
                    j.this.bMd.iI(albumId);
                    j.this.bNl.setData(iK);
                    if (j.this.bNl.getCount() <= 0) {
                        j.this.bNm.setVisibility(0);
                    } else {
                        j.this.bNm.setVisibility(8);
                    }
                    j.this.bNi.setText(name);
                    j.this.bNk.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bMY = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bMr == null || j.this.bMd == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bMd.WP()) {
                    j.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bMd.isAdded(imageFileInfo)) {
                    j.this.bMr.b(imageFileInfo);
                } else {
                    j.this.bMr.a(imageFileInfo);
                }
                j.this.bMd.a((VideoFileInfo) null);
                j.this.bNl.notifyDataSetChanged();
                j.this.WZ();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bMd.WO()) {
                    j.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bMd.b(videoFileInfo)) {
                        j.this.bMd.a((VideoFileInfo) null);
                    } else {
                        j.this.bMd.a(videoFileInfo);
                    }
                    j.this.bMd.WQ();
                    j.this.bNl.notifyDataSetChanged();
                    j.this.WZ();
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
        this.bMr = albumActivity;
        this.bMd = this.bMr.Wz();
        d.WW().a(this);
        this.bNe = new MediaStoreLoader(this.bMr);
        this.bNj = new com.baidu.live.tieba.write.a.a(this.bMr);
        this.bNj.setOnDismissListener(this.mOnDismissListener);
        this.bNj.a(this.bNq);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.bMr).inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bNf = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bNn = this.mView.findViewById(a.f.layout_title);
        this.bNi = (TextView) this.mView.findViewById(a.f.album_title);
        this.bNg = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bNh = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bNo = this.mView.findViewById(a.f.navi_line);
        this.bMu = this.mView.findViewById(a.f.layout_bottom);
        this.bMw = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bMv = (TextView) this.mView.findViewById(a.f.next_step);
        this.bMd.iI(AlbumData.ALBUM_ID_ALL);
        this.bNi.setText(this.bMr.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bNm = new CommonEmptyView(this.bMr);
        this.bNm.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bNm.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bNm.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bNm.setVisibility(8);
        this.bNm.addToParent(this.bNf);
        this.bNk = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bNk.setSelector(a.c.sdk_transparent);
        this.bNl = new i(this.bMr, this.bMd);
        this.bNk.setAdapter((ListAdapter) this.bNl);
        this.bNk.setOuterOnScrollListener(this);
        this.bNl.a(this.bMY);
        this.bNl.a(this.bMX);
        this.bMv.setOnClickListener(this.bMr);
        this.bNg.setOnClickListener(this.bMr);
        this.bNh.setOnClickListener(this.bMr);
        this.bMw.setOnClickListener(this.bMr);
        this.bNi.setOnClickListener(this.mOnClickListener);
        this.bMu.setOnClickListener(this.mOnClickListener);
        WZ();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bNp == null) {
            this.bNp = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bNp.setCancelListener(null);
        this.bNp.setTipString(a.h.sdk_loading);
        this.bNp.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bMr.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        int count;
        String string;
        if (this.bMd != null && this.bMv != null) {
            if (this.bMd.WP()) {
                int i = this.bMd.WP() ? 1 : 0;
                string = this.bMr.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bMd.WR());
                string = this.bMr.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMd.getMaxImagesAllowed())});
            }
            this.bMv.setText(string);
            this.bMv.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.isPaused = false;
        WE();
    }

    private void WD() {
        if (this.bMd == null && this.bMr != null) {
            this.bMd = this.bMr.Wz();
        }
        if (this.bMd != null) {
            Xa();
            dj(this.bMd.isOriginalImg());
        }
    }

    private void Xa() {
        if (this.bNe == null) {
            this.bNe = new MediaStoreLoader(this.bMr);
        }
        this.bNe.loadAll(this.bMr.Wy() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bNp != null) {
                    j.this.bNp.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bMd != null && resutMediaStore != null) {
                    j.this.bMd.a(resutMediaStore);
                    String WT = j.this.bMd.WT();
                    j.this.bMd.iI(WT);
                    j.this.bNl.setData(j.this.bMd.iK(WT));
                    if (j.this.bNl.getCount() <= 0) {
                        j.this.bNm.setVisibility(0);
                    } else {
                        j.this.bNm.setVisibility(8);
                    }
                    j.this.bNk.smoothScrollToPosition(0);
                    j.this.WZ();
                }
                j.this.bNk.Xc();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bNo, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bNi, a.c.sdk_cp_cont_b, i);
        if (this.bMr.Wy() == 1) {
            SkinManager.setImageResource(this.bNg, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bNh.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bNh, a.c.sdk_ph_navi_back_text_color);
            this.bNg.setVisibility(8);
        }
        if (this.bNi != null) {
            this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bNl != null) {
            this.bNl.notifyDataSetChanged();
        }
        if (this.bMd != null) {
            dj(this.bMd.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View WX() {
        return this.bMr.Wy() == 1 ? this.bNg : this.bNh;
    }

    public View Xb() {
        return this.bMv;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dl(boolean z) {
        WE();
    }

    private void WE() {
        if (!this.isPaused) {
            WD();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bNl.dm(true);
        } else if (this.bNl.isScroll()) {
            this.bNl.dm(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bNk != null) {
            int firstVisiblePosition = this.bNk.getFirstVisiblePosition();
            int lastVisiblePosition = this.bNk.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bNk.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bNl != null) {
                    this.bNl.b((ImageView) childAt.findViewById(a.f.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        WZ();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bNl != null) {
            o(this.bNl.e(imageFileInfo), z);
        }
    }

    public View WK() {
        return this.bMw;
    }

    public void dj(boolean z) {
        if (this.bMr != null && this.bMw != null) {
            this.bMw.setText(this.bMr.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_cont_f);
        }
    }
}
