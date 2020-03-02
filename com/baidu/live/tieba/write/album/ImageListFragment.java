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
    private c aBT;
    private MediaStoreLoader aCP;
    private RelativeLayout aCQ;
    private ImageView aCR;
    private TextView aCS;
    private TextView aCT;
    private com.baidu.live.tieba.write.a.a aCU;
    private TransparentHeadGridView aCV;
    private h aCW;
    private CommonEmptyView aCX;
    private View aCY;
    private View aCZ;
    private AlbumActivity aCh;
    private View aCn;
    private TextView aCo;
    private TextView aCp;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog aDa = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aBT != null) {
                if (view == ImageListFragment.this.aCT) {
                    ImageListFragment.this.aCU.b(ImageListFragment.this.aBT.AK(), ImageListFragment.this.aBT.AI());
                    ImageListFragment.this.aCU.R(ImageListFragment.this.aCY);
                    ImageListFragment.this.aCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aCn) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCT != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aCT.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aCI = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aBT != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aBT.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aCh.cM(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0101a aDb = new a.InterfaceC0101a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0101a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.aBT != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aBT.AI()) && (ec = ImageListFragment.this.aBT.ec(albumId)) != null) {
                    ImageListFragment.this.aBT.ea(albumId);
                    ImageListFragment.this.aCW.setData(ec);
                    if (ImageListFragment.this.aCW.getCount() <= 0) {
                        ImageListFragment.this.aCX.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCX.setVisibility(8);
                    }
                    ImageListFragment.this.aCT.setText(name);
                    ImageListFragment.this.aCV.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aCJ = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aCh == null || ImageListFragment.this.aBT == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aBT.AE()) {
                    ImageListFragment.this.aCh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aBT.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aCh.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aCh.a(imageFileInfo);
                }
                ImageListFragment.this.aBT.a((VideoFileInfo) null);
                ImageListFragment.this.aCW.notifyDataSetChanged();
                ImageListFragment.this.AN();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aBT.AD()) {
                    ImageListFragment.this.aCh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aBT.b(videoFileInfo)) {
                        ImageListFragment.this.aBT.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aBT.a(videoFileInfo);
                    }
                    ImageListFragment.this.aBT.AF();
                    ImageListFragment.this.aCW.notifyDataSetChanged();
                    ImageListFragment.this.AN();
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
        this.aCh = (AlbumActivity) getBaseFragmentActivity();
        this.aBT = this.aCh.Ao();
        d.AM().a(this);
        this.aCP = new MediaStoreLoader(this.aCh);
        this.aCU = new com.baidu.live.tieba.write.a.a(this.aCh);
        this.aCU.setOnDismissListener(this.mOnDismissListener);
        this.aCU.a(this.aDb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aCQ = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aCY = this.mView.findViewById(a.g.layout_title);
        this.aCT = (TextView) this.mView.findViewById(a.g.album_title);
        this.aCR = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aCS = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aCZ = this.mView.findViewById(a.g.navi_line);
        this.aCn = this.mView.findViewById(a.g.layout_bottom);
        this.aCp = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aCo = (TextView) this.mView.findViewById(a.g.next_step);
        this.aBT.ea(AlbumData.ALBUM_ID_ALL);
        this.aCT.setText(this.aCh.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aCX = new CommonEmptyView(getContext());
        this.aCX.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aCX.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aCX.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aCX.setVisibility(8);
        this.aCX.addToParent(this.aCQ);
        this.aCV = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aCV.setSelector(a.d.sdk_transparent);
        this.aCW = new h(this.aCh, this.aBT);
        this.aCV.setAdapter((ListAdapter) this.aCW);
        this.aCV.setOuterOnScrollListener(this);
        this.aCW.a(this.aCJ);
        this.aCW.a(this.aCI);
        this.aCo.setOnClickListener(this.aCh);
        this.aCR.setOnClickListener(this.aCh);
        this.aCS.setOnClickListener(this.aCh);
        this.aCp.setOnClickListener(this.aCh);
        this.aCT.setOnClickListener(this.mOnClickListener);
        this.aCn.setOnClickListener(this.mOnClickListener);
        AN();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aDa == null) {
            this.aDa = new BlueCircleProgressDialog(getPageContext());
        }
        this.aDa.setCancelListener(null);
        this.aDa.setTipString(a.i.sdk_loading);
        this.aDa.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aCh.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        int count;
        String string;
        if (this.aBT != null && this.aCo != null) {
            if (this.aBT.AE()) {
                int i = this.aBT.AE() ? 1 : 0;
                count = i;
                string = this.aCh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aBT.AG());
                string = this.aCh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBT.getMaxImagesAllowed())});
            }
            this.aCo.setText(string);
            this.aCo.setEnabled(count > 0);
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
            AC();
        }
    }

    private void Az() {
        if (this.aBT == null && this.aCh != null) {
            this.aBT = this.aCh.Ao();
        }
        if (this.aBT != null) {
            if (!this.aBT.AL()) {
                this.aCW.notifyDataSetChanged();
            } else {
                AO();
            }
            bt(this.aBT.isOriginalImg());
        }
    }

    private void AO() {
        if (this.aCP == null) {
            this.aCP = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aCP.loadAll(this.aCh.An() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aDa != null) {
                    ImageListFragment.this.aDa.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aBT != null && resutMediaStore != null) {
                    ImageListFragment.this.aBT.a(resutMediaStore);
                    String AI = ImageListFragment.this.aBT.AI();
                    ImageListFragment.this.aBT.ea(AI);
                    ImageListFragment.this.aCW.setData(ImageListFragment.this.aBT.ec(AI));
                    if (ImageListFragment.this.aCW.getCount() <= 0) {
                        ImageListFragment.this.aCX.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCX.setVisibility(8);
                    }
                    ImageListFragment.this.aCV.smoothScrollToPosition(0);
                    ImageListFragment.this.AN();
                }
                ImageListFragment.this.aCV.AQ();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aCZ, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aCT, a.d.sdk_cp_cont_b, i);
        if (this.aCh.An() == 1) {
            SkinManager.setImageResource(this.aCR, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aCS.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aCS, a.d.sdk_ph_navi_back_text_color);
            this.aCR.setVisibility(8);
        }
        if (this.aCT != null) {
            this.aCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aCW != null) {
            this.aCW.notifyDataSetChanged();
        }
        if (this.aBT != null) {
            bt(this.aBT.isOriginalImg());
        }
    }

    public View AA() {
        return this.aCh.An() == 1 ? this.aCR : this.aCS;
    }

    public View AP() {
        return this.aCo;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aCU != null) {
            this.aCU.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aCP != null) {
            this.aCP.cancelLoadTask();
        }
        if (this.aCh != null) {
            this.aCh.closeLoadingDialog();
        }
        if (this.aDa != null) {
            this.aDa.setDialogVisiable(false);
        }
        d.AM().b(this);
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
        AC();
    }

    private void AC() {
        if (!isHidden() && !this.isPaused) {
            Az();
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
            this.aCW.bw(true);
        } else if (this.aCW.isScroll()) {
            this.aCW.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aCV != null) {
            int firstVisiblePosition = this.aCV.getFirstVisiblePosition();
            int lastVisiblePosition = this.aCV.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aCV.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aCW != null) {
                    this.aCW.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AN();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aCW != null) {
            i(this.aCW.e(imageFileInfo), z);
        }
    }

    public View Aw() {
        return this.aCp;
    }

    public void bt(boolean z) {
        if (this.aCh != null && this.aCp != null) {
            this.aCp.setText(this.aCh.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aCp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aCp, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aCp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aCp, a.d.sdk_cp_cont_f);
        }
    }
}
