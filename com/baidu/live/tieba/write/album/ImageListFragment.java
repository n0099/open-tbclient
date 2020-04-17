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
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private c aVP;
    private MediaStoreLoader aWL;
    private RelativeLayout aWM;
    private ImageView aWN;
    private TextView aWO;
    private TextView aWP;
    private com.baidu.live.tieba.write.a.a aWQ;
    private TransparentHeadGridView aWR;
    private h aWS;
    private CommonEmptyView aWT;
    private View aWU;
    private View aWV;
    private boolean aWW;
    private AlbumActivity aWd;
    private View aWj;
    private TextView aWk;
    private TextView aWl;
    private View mView;
    private BlueCircleProgressDialog aWX = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aVP != null) {
                if (view == ImageListFragment.this.aWP) {
                    ImageListFragment.this.aWQ.b(ImageListFragment.this.aVP.FP(), ImageListFragment.this.aVP.FN());
                    ImageListFragment.this.aWQ.T(ImageListFragment.this.aWU);
                    ImageListFragment.this.aWP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aWj) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aWP != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aWP.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aWE = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aVP != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aVP.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aWd.db(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0127a aWY = new a.InterfaceC0127a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0127a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> eU;
            if (ImageListFragment.this.aVP != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aVP.FN()) && (eU = ImageListFragment.this.aVP.eU(albumId)) != null) {
                    ImageListFragment.this.aVP.eS(albumId);
                    ImageListFragment.this.aWS.setData(eU);
                    if (ImageListFragment.this.aWS.getCount() <= 0) {
                        ImageListFragment.this.aWT.setVisibility(0);
                    } else {
                        ImageListFragment.this.aWT.setVisibility(8);
                    }
                    ImageListFragment.this.aWP.setText(name);
                    ImageListFragment.this.aWR.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aWF = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aWd == null || ImageListFragment.this.aVP == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aVP.FJ()) {
                    ImageListFragment.this.aWd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aVP.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aWd.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aWd.a(imageFileInfo);
                }
                ImageListFragment.this.aVP.a((VideoFileInfo) null);
                ImageListFragment.this.aWS.notifyDataSetChanged();
                ImageListFragment.this.FS();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aVP.FI()) {
                    ImageListFragment.this.aWd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aVP.b(videoFileInfo)) {
                        ImageListFragment.this.aVP.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aVP.a(videoFileInfo);
                    }
                    ImageListFragment.this.aVP.FK();
                    ImageListFragment.this.aWS.notifyDataSetChanged();
                    ImageListFragment.this.FS();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aWd = (AlbumActivity) getBaseFragmentActivity();
        this.aVP = this.aWd.Ft();
        d.FR().a(this);
        this.aWL = new MediaStoreLoader(this.aWd);
        this.aWQ = new com.baidu.live.tieba.write.a.a(this.aWd);
        this.aWQ.setOnDismissListener(this.mOnDismissListener);
        this.aWQ.a(this.aWY);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aWM = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aWU = this.mView.findViewById(a.g.layout_title);
        this.aWP = (TextView) this.mView.findViewById(a.g.album_title);
        this.aWN = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aWO = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aWV = this.mView.findViewById(a.g.navi_line);
        this.aWj = this.mView.findViewById(a.g.layout_bottom);
        this.aWl = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aWk = (TextView) this.mView.findViewById(a.g.next_step);
        this.aVP.eS(AlbumData.ALBUM_ID_ALL);
        this.aWP.setText(this.aWd.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aWT = new CommonEmptyView(getContext());
        this.aWT.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aWT.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aWT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aWT.setVisibility(8);
        this.aWT.addToParent(this.aWM);
        this.aWR = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aWR.setSelector(a.d.sdk_transparent);
        this.aWS = new h(this.aWd, this.aVP);
        this.aWR.setAdapter((ListAdapter) this.aWS);
        this.aWR.setOuterOnScrollListener(this);
        this.aWS.a(this.aWF);
        this.aWS.a(this.aWE);
        this.aWk.setOnClickListener(this.aWd);
        this.aWN.setOnClickListener(this.aWd);
        this.aWO.setOnClickListener(this.aWd);
        this.aWl.setOnClickListener(this.aWd);
        this.aWP.setOnClickListener(this.mOnClickListener);
        this.aWj.setOnClickListener(this.mOnClickListener);
        FS();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aWX == null) {
            this.aWX = new BlueCircleProgressDialog(getPageContext());
        }
        this.aWX.setCancelListener(null);
        this.aWX.setTipString(a.i.sdk_loading);
        this.aWX.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aWd.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS() {
        int count;
        String string;
        if (this.aVP != null && this.aWk != null) {
            if (this.aVP.FJ()) {
                int i = this.aVP.FJ() ? 1 : 0;
                count = i;
                string = this.aWd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aVP.FL());
                string = this.aWd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aVP.getMaxImagesAllowed())});
            }
            this.aWk.setText(string);
            this.aWk.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aWW = false;
        if (isShow()) {
            FH();
        }
    }

    private void FE() {
        if (this.aVP == null && this.aWd != null) {
            this.aVP = this.aWd.Ft();
        }
        if (this.aVP != null) {
            if (!this.aVP.FQ()) {
                this.aWS.notifyDataSetChanged();
            } else {
                FT();
            }
            bY(this.aVP.isOriginalImg());
        }
    }

    private void FT() {
        if (this.aWL == null) {
            this.aWL = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aWL.loadAll(this.aWd.Fs() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aWX != null) {
                    ImageListFragment.this.aWX.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aVP != null && resutMediaStore != null) {
                    ImageListFragment.this.aVP.a(resutMediaStore);
                    String FN = ImageListFragment.this.aVP.FN();
                    ImageListFragment.this.aVP.eS(FN);
                    ImageListFragment.this.aWS.setData(ImageListFragment.this.aVP.eU(FN));
                    if (ImageListFragment.this.aWS.getCount() <= 0) {
                        ImageListFragment.this.aWT.setVisibility(0);
                    } else {
                        ImageListFragment.this.aWT.setVisibility(8);
                    }
                    ImageListFragment.this.aWR.smoothScrollToPosition(0);
                    ImageListFragment.this.FS();
                }
                ImageListFragment.this.aWR.FV();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aWV, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aWP, a.d.sdk_cp_cont_b, i);
        if (this.aWd.Fs() == 1) {
            SkinManager.setImageResource(this.aWN, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aWO.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aWO, a.d.sdk_ph_navi_back_text_color);
            this.aWN.setVisibility(8);
        }
        if (this.aWP != null) {
            this.aWP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aWS != null) {
            this.aWS.notifyDataSetChanged();
        }
        if (this.aVP != null) {
            bY(this.aVP.isOriginalImg());
        }
    }

    public View FF() {
        return this.aWd.Fs() == 1 ? this.aWN : this.aWO;
    }

    public View FU() {
        return this.aWk;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aWQ != null) {
            this.aWQ.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aWL != null) {
            this.aWL.cancelLoadTask();
        }
        if (this.aWd != null) {
            this.aWd.closeLoadingDialog();
        }
        if (this.aWX != null) {
            this.aWX.setDialogVisiable(false);
        }
        d.FR().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aWW = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void ca(boolean z) {
        FH();
    }

    private void FH() {
        if (!isHidden() && !this.aWW) {
            FE();
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
            this.aWS.cb(true);
        } else if (this.aWS.isScroll()) {
            this.aWS.cb(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.aWR != null) {
            int firstVisiblePosition = this.aWR.getFirstVisiblePosition();
            int lastVisiblePosition = this.aWR.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aWR.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aWS != null) {
                    this.aWS.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        FS();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aWS != null) {
            l(this.aWS.e(imageFileInfo), z);
        }
    }

    public View FB() {
        return this.aWl;
    }

    public void bY(boolean z) {
        if (this.aWd != null && this.aWl != null) {
            this.aWl.setText(this.aWd.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aWl.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aWl, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aWl.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aWl, a.d.sdk_cp_cont_f);
        }
    }
}
