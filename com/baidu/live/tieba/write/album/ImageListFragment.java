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
    private c aBS;
    private MediaStoreLoader aCO;
    private RelativeLayout aCP;
    private ImageView aCQ;
    private TextView aCR;
    private TextView aCS;
    private com.baidu.live.tieba.write.a.a aCT;
    private TransparentHeadGridView aCU;
    private h aCV;
    private CommonEmptyView aCW;
    private View aCX;
    private View aCY;
    private AlbumActivity aCg;
    private View aCm;
    private TextView aCn;
    private TextView aCo;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog aCZ = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aBS != null) {
                if (view == ImageListFragment.this.aCS) {
                    ImageListFragment.this.aCT.b(ImageListFragment.this.aBS.AI(), ImageListFragment.this.aBS.AG());
                    ImageListFragment.this.aCT.R(ImageListFragment.this.aCX);
                    ImageListFragment.this.aCS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aCm) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCS != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aCS.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aCH = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aBS != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aBS.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aCg.cM(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0101a aDa = new a.InterfaceC0101a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0101a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.aBS != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aBS.AG()) && (ec = ImageListFragment.this.aBS.ec(albumId)) != null) {
                    ImageListFragment.this.aBS.ea(albumId);
                    ImageListFragment.this.aCV.setData(ec);
                    if (ImageListFragment.this.aCV.getCount() <= 0) {
                        ImageListFragment.this.aCW.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCW.setVisibility(8);
                    }
                    ImageListFragment.this.aCS.setText(name);
                    ImageListFragment.this.aCU.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aCI = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aCg == null || ImageListFragment.this.aBS == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aBS.AC()) {
                    ImageListFragment.this.aCg.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aBS.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aCg.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aCg.a(imageFileInfo);
                }
                ImageListFragment.this.aBS.a((VideoFileInfo) null);
                ImageListFragment.this.aCV.notifyDataSetChanged();
                ImageListFragment.this.AL();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aBS.AB()) {
                    ImageListFragment.this.aCg.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aBS.b(videoFileInfo)) {
                        ImageListFragment.this.aBS.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aBS.a(videoFileInfo);
                    }
                    ImageListFragment.this.aBS.AD();
                    ImageListFragment.this.aCV.notifyDataSetChanged();
                    ImageListFragment.this.AL();
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
        this.aCg = (AlbumActivity) getBaseFragmentActivity();
        this.aBS = this.aCg.Am();
        d.AK().a(this);
        this.aCO = new MediaStoreLoader(this.aCg);
        this.aCT = new com.baidu.live.tieba.write.a.a(this.aCg);
        this.aCT.setOnDismissListener(this.mOnDismissListener);
        this.aCT.a(this.aDa);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aCP = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aCX = this.mView.findViewById(a.g.layout_title);
        this.aCS = (TextView) this.mView.findViewById(a.g.album_title);
        this.aCQ = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aCR = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aCY = this.mView.findViewById(a.g.navi_line);
        this.aCm = this.mView.findViewById(a.g.layout_bottom);
        this.aCo = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aCn = (TextView) this.mView.findViewById(a.g.next_step);
        this.aBS.ea(AlbumData.ALBUM_ID_ALL);
        this.aCS.setText(this.aCg.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aCW = new CommonEmptyView(getContext());
        this.aCW.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aCW.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aCW.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aCW.setVisibility(8);
        this.aCW.addToParent(this.aCP);
        this.aCU = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aCU.setSelector(a.d.sdk_transparent);
        this.aCV = new h(this.aCg, this.aBS);
        this.aCU.setAdapter((ListAdapter) this.aCV);
        this.aCU.setOuterOnScrollListener(this);
        this.aCV.a(this.aCI);
        this.aCV.a(this.aCH);
        this.aCn.setOnClickListener(this.aCg);
        this.aCQ.setOnClickListener(this.aCg);
        this.aCR.setOnClickListener(this.aCg);
        this.aCo.setOnClickListener(this.aCg);
        this.aCS.setOnClickListener(this.mOnClickListener);
        this.aCm.setOnClickListener(this.mOnClickListener);
        AL();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aCZ == null) {
            this.aCZ = new BlueCircleProgressDialog(getPageContext());
        }
        this.aCZ.setCancelListener(null);
        this.aCZ.setTipString(a.i.sdk_loading);
        this.aCZ.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aCg.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL() {
        int count;
        String string;
        if (this.aBS != null && this.aCn != null) {
            if (this.aBS.AC()) {
                int i = this.aBS.AC() ? 1 : 0;
                count = i;
                string = this.aCg.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aBS.AE());
                string = this.aCg.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBS.getMaxImagesAllowed())});
            }
            this.aCn.setText(string);
            this.aCn.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            AA();
        }
    }

    private void Ax() {
        if (this.aBS == null && this.aCg != null) {
            this.aBS = this.aCg.Am();
        }
        if (this.aBS != null) {
            if (!this.aBS.AJ()) {
                this.aCV.notifyDataSetChanged();
            } else {
                AM();
            }
            bt(this.aBS.isOriginalImg());
        }
    }

    private void AM() {
        if (this.aCO == null) {
            this.aCO = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aCO.loadAll(this.aCg.Al() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aCZ != null) {
                    ImageListFragment.this.aCZ.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aBS != null && resutMediaStore != null) {
                    ImageListFragment.this.aBS.a(resutMediaStore);
                    String AG = ImageListFragment.this.aBS.AG();
                    ImageListFragment.this.aBS.ea(AG);
                    ImageListFragment.this.aCV.setData(ImageListFragment.this.aBS.ec(AG));
                    if (ImageListFragment.this.aCV.getCount() <= 0) {
                        ImageListFragment.this.aCW.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCW.setVisibility(8);
                    }
                    ImageListFragment.this.aCU.smoothScrollToPosition(0);
                    ImageListFragment.this.AL();
                }
                ImageListFragment.this.aCU.AO();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aCY, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aCS, a.d.sdk_cp_cont_b, i);
        if (this.aCg.Al() == 1) {
            SkinManager.setImageResource(this.aCQ, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aCR.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aCR, a.d.sdk_ph_navi_back_text_color);
            this.aCQ.setVisibility(8);
        }
        if (this.aCS != null) {
            this.aCS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aCV != null) {
            this.aCV.notifyDataSetChanged();
        }
        if (this.aBS != null) {
            bt(this.aBS.isOriginalImg());
        }
    }

    public View Ay() {
        return this.aCg.Al() == 1 ? this.aCQ : this.aCR;
    }

    public View AN() {
        return this.aCn;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aCT != null) {
            this.aCT.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aCO != null) {
            this.aCO.cancelLoadTask();
        }
        if (this.aCg != null) {
            this.aCg.closeLoadingDialog();
        }
        if (this.aCZ != null) {
            this.aCZ.setDialogVisiable(false);
        }
        d.AK().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void bv(boolean z) {
        AA();
    }

    private void AA() {
        if (!isHidden() && !this.isPaused) {
            Ax();
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
            this.aCV.bw(true);
        } else if (this.aCV.isScroll()) {
            this.aCV.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aCU != null) {
            int firstVisiblePosition = this.aCU.getFirstVisiblePosition();
            int lastVisiblePosition = this.aCU.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aCU.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aCV != null) {
                    this.aCV.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AL();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aCV != null) {
            i(this.aCV.e(imageFileInfo), z);
        }
    }

    public View Au() {
        return this.aCo;
    }

    public void bt(boolean z) {
        if (this.aCg != null && this.aCo != null) {
            this.aCo.setText(this.aCg.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aCo.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aCo, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aCo.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aCo, a.d.sdk_cp_cont_f);
        }
    }
}
