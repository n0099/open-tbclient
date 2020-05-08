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
    private c aVU;
    private MediaStoreLoader aWQ;
    private RelativeLayout aWR;
    private ImageView aWS;
    private TextView aWT;
    private TextView aWU;
    private com.baidu.live.tieba.write.a.a aWV;
    private TransparentHeadGridView aWW;
    private h aWX;
    private CommonEmptyView aWY;
    private View aWZ;
    private AlbumActivity aWi;
    private View aWo;
    private TextView aWp;
    private TextView aWq;
    private View aXa;
    private boolean aXb;
    private View mView;
    private BlueCircleProgressDialog aXc = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aVU != null) {
                if (view == ImageListFragment.this.aWU) {
                    ImageListFragment.this.aWV.b(ImageListFragment.this.aVU.FO(), ImageListFragment.this.aVU.FM());
                    ImageListFragment.this.aWV.T(ImageListFragment.this.aWZ);
                    ImageListFragment.this.aWU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aWo) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aWU != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aWU.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aWJ = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aVU != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aVU.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aWi.db(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0148a aXd = new a.InterfaceC0148a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0148a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> eU;
            if (ImageListFragment.this.aVU != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aVU.FM()) && (eU = ImageListFragment.this.aVU.eU(albumId)) != null) {
                    ImageListFragment.this.aVU.eS(albumId);
                    ImageListFragment.this.aWX.setData(eU);
                    if (ImageListFragment.this.aWX.getCount() <= 0) {
                        ImageListFragment.this.aWY.setVisibility(0);
                    } else {
                        ImageListFragment.this.aWY.setVisibility(8);
                    }
                    ImageListFragment.this.aWU.setText(name);
                    ImageListFragment.this.aWW.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aWK = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aWi == null || ImageListFragment.this.aVU == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aVU.FI()) {
                    ImageListFragment.this.aWi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aVU.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aWi.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aWi.a(imageFileInfo);
                }
                ImageListFragment.this.aVU.a((VideoFileInfo) null);
                ImageListFragment.this.aWX.notifyDataSetChanged();
                ImageListFragment.this.FR();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aVU.FH()) {
                    ImageListFragment.this.aWi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aVU.b(videoFileInfo)) {
                        ImageListFragment.this.aVU.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aVU.a(videoFileInfo);
                    }
                    ImageListFragment.this.aVU.FJ();
                    ImageListFragment.this.aWX.notifyDataSetChanged();
                    ImageListFragment.this.FR();
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
        this.aWi = (AlbumActivity) getBaseFragmentActivity();
        this.aVU = this.aWi.Fs();
        d.FQ().a(this);
        this.aWQ = new MediaStoreLoader(this.aWi);
        this.aWV = new com.baidu.live.tieba.write.a.a(this.aWi);
        this.aWV.setOnDismissListener(this.mOnDismissListener);
        this.aWV.a(this.aXd);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aWR = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aWZ = this.mView.findViewById(a.g.layout_title);
        this.aWU = (TextView) this.mView.findViewById(a.g.album_title);
        this.aWS = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aWT = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aXa = this.mView.findViewById(a.g.navi_line);
        this.aWo = this.mView.findViewById(a.g.layout_bottom);
        this.aWq = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aWp = (TextView) this.mView.findViewById(a.g.next_step);
        this.aVU.eS(AlbumData.ALBUM_ID_ALL);
        this.aWU.setText(this.aWi.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aWY = new CommonEmptyView(getContext());
        this.aWY.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aWY.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aWY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aWY.setVisibility(8);
        this.aWY.addToParent(this.aWR);
        this.aWW = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aWW.setSelector(a.d.sdk_transparent);
        this.aWX = new h(this.aWi, this.aVU);
        this.aWW.setAdapter((ListAdapter) this.aWX);
        this.aWW.setOuterOnScrollListener(this);
        this.aWX.a(this.aWK);
        this.aWX.a(this.aWJ);
        this.aWp.setOnClickListener(this.aWi);
        this.aWS.setOnClickListener(this.aWi);
        this.aWT.setOnClickListener(this.aWi);
        this.aWq.setOnClickListener(this.aWi);
        this.aWU.setOnClickListener(this.mOnClickListener);
        this.aWo.setOnClickListener(this.mOnClickListener);
        FR();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aXc == null) {
            this.aXc = new BlueCircleProgressDialog(getPageContext());
        }
        this.aXc.setCancelListener(null);
        this.aXc.setTipString(a.i.sdk_loading);
        this.aXc.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aWi.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        int count;
        String string;
        if (this.aVU != null && this.aWp != null) {
            if (this.aVU.FI()) {
                int i = this.aVU.FI() ? 1 : 0;
                count = i;
                string = this.aWi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aVU.FK());
                string = this.aWi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aVU.getMaxImagesAllowed())});
            }
            this.aWp.setText(string);
            this.aWp.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aXb = false;
        if (isShow()) {
            FG();
        }
    }

    private void FD() {
        if (this.aVU == null && this.aWi != null) {
            this.aVU = this.aWi.Fs();
        }
        if (this.aVU != null) {
            if (!this.aVU.FP()) {
                this.aWX.notifyDataSetChanged();
            } else {
                FS();
            }
            bY(this.aVU.isOriginalImg());
        }
    }

    private void FS() {
        if (this.aWQ == null) {
            this.aWQ = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aWQ.loadAll(this.aWi.Fr() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aXc != null) {
                    ImageListFragment.this.aXc.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aVU != null && resutMediaStore != null) {
                    ImageListFragment.this.aVU.a(resutMediaStore);
                    String FM = ImageListFragment.this.aVU.FM();
                    ImageListFragment.this.aVU.eS(FM);
                    ImageListFragment.this.aWX.setData(ImageListFragment.this.aVU.eU(FM));
                    if (ImageListFragment.this.aWX.getCount() <= 0) {
                        ImageListFragment.this.aWY.setVisibility(0);
                    } else {
                        ImageListFragment.this.aWY.setVisibility(8);
                    }
                    ImageListFragment.this.aWW.smoothScrollToPosition(0);
                    ImageListFragment.this.FR();
                }
                ImageListFragment.this.aWW.FU();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aXa, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aWU, a.d.sdk_cp_cont_b, i);
        if (this.aWi.Fr() == 1) {
            SkinManager.setImageResource(this.aWS, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aWT.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aWT, a.d.sdk_ph_navi_back_text_color);
            this.aWS.setVisibility(8);
        }
        if (this.aWU != null) {
            this.aWU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aWX != null) {
            this.aWX.notifyDataSetChanged();
        }
        if (this.aVU != null) {
            bY(this.aVU.isOriginalImg());
        }
    }

    public View FE() {
        return this.aWi.Fr() == 1 ? this.aWS : this.aWT;
    }

    public View FT() {
        return this.aWp;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aWV != null) {
            this.aWV.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aWQ != null) {
            this.aWQ.cancelLoadTask();
        }
        if (this.aWi != null) {
            this.aWi.closeLoadingDialog();
        }
        if (this.aXc != null) {
            this.aXc.setDialogVisiable(false);
        }
        d.FQ().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aXb = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void ca(boolean z) {
        FG();
    }

    private void FG() {
        if (!isHidden() && !this.aXb) {
            FD();
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
            this.aWX.cb(true);
        } else if (this.aWX.isScroll()) {
            this.aWX.cb(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.aWW != null) {
            int firstVisiblePosition = this.aWW.getFirstVisiblePosition();
            int lastVisiblePosition = this.aWW.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aWW.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aWX != null) {
                    this.aWX.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        FR();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aWX != null) {
            l(this.aWX.e(imageFileInfo), z);
        }
    }

    public View FA() {
        return this.aWq;
    }

    public void bY(boolean z) {
        if (this.aWi != null && this.aWq != null) {
            this.aWq.setText(this.aWi.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aWq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aWq, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aWq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aWq, a.d.sdk_cp_cont_f);
        }
    }
}
