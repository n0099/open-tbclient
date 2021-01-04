package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.MediaStoreLoadCallback;
import com.baidu.live.tbadk.album.MediaStoreLoader;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.BaseFragment;
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
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
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
    private BlueCircleProgressDialog bNp = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bMd != null) {
                if (view == ImageListFragment.this.bNi) {
                    ImageListFragment.this.bNj.c(ImageListFragment.this.bMd.WV(), ImageListFragment.this.bMd.WT());
                    ImageListFragment.this.bNj.O(ImageListFragment.this.bNn);
                    ImageListFragment.this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bMu) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bNi != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bNi.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bMX = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bMd != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bMd.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bMr.gs(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0225a bNq = new a.InterfaceC0225a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0225a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> iK;
            if (ImageListFragment.this.bMd != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bMd.WT()) && (iK = ImageListFragment.this.bMd.iK(albumId)) != null) {
                    ImageListFragment.this.bMd.iI(albumId);
                    ImageListFragment.this.bNl.setData(iK);
                    if (ImageListFragment.this.bNl.getCount() <= 0) {
                        ImageListFragment.this.bNm.setVisibility(0);
                    } else {
                        ImageListFragment.this.bNm.setVisibility(8);
                    }
                    ImageListFragment.this.bNi.setText(name);
                    ImageListFragment.this.bNk.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bMY = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bMr == null || ImageListFragment.this.bMd == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bMd.WP()) {
                    ImageListFragment.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bMd.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bMr.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bMr.a(imageFileInfo);
                }
                ImageListFragment.this.bMd.a((VideoFileInfo) null);
                ImageListFragment.this.bNl.notifyDataSetChanged();
                ImageListFragment.this.WZ();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bMd.WO()) {
                    ImageListFragment.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bMd.b(videoFileInfo)) {
                        ImageListFragment.this.bMd.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bMd.a(videoFileInfo);
                    }
                    ImageListFragment.this.bMd.WQ();
                    ImageListFragment.this.bNl.notifyDataSetChanged();
                    ImageListFragment.this.WZ();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMr = (AlbumActivity) getBaseFragmentActivity();
        this.bMd = this.bMr.Wz();
        d.WW().a(this);
        this.bNe = new MediaStoreLoader(this.bMr);
        this.bNj = new com.baidu.live.tieba.write.a.a(this.bMr);
        this.bNj.setOnDismissListener(this.mOnDismissListener);
        this.bNj.a(this.bNq);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
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
        this.bNm = new CommonEmptyView(getContext());
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
            this.bNp = new BlueCircleProgressDialog(getPageContext());
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            WE();
        }
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
            this.bNe = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bNe.loadAll(this.bMr.Wy() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bNp != null) {
                    ImageListFragment.this.bNp.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bMd != null && resutMediaStore != null) {
                    ImageListFragment.this.bMd.a(resutMediaStore);
                    String WT = ImageListFragment.this.bMd.WT();
                    ImageListFragment.this.bMd.iI(WT);
                    ImageListFragment.this.bNl.setData(ImageListFragment.this.bMd.iK(WT));
                    if (ImageListFragment.this.bNl.getCount() <= 0) {
                        ImageListFragment.this.bNm.setVisibility(0);
                    } else {
                        ImageListFragment.this.bNm.setVisibility(8);
                    }
                    ImageListFragment.this.bNk.smoothScrollToPosition(0);
                    ImageListFragment.this.WZ();
                }
                ImageListFragment.this.bNk.Xc();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
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

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bNj != null) {
            this.bNj.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bNe != null) {
            this.bNe.cancelLoadTask();
        }
        if (this.bMr != null) {
            this.bMr.closeLoadingDialog();
        }
        if (this.bNp != null) {
            this.bNp.setDialogVisiable(false);
        }
        d.WW().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dl(boolean z) {
        WE();
    }

    private void WE() {
        if (!isHidden() && !this.isPaused) {
            WD();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.bNl.dm(true);
        } else if (this.bNl.isScroll()) {
            this.bNl.dm(false);
        }
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
