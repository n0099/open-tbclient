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
    private c aBU;
    private MediaStoreLoader aCQ;
    private RelativeLayout aCR;
    private ImageView aCS;
    private TextView aCT;
    private TextView aCU;
    private com.baidu.live.tieba.write.a.a aCV;
    private TransparentHeadGridView aCW;
    private h aCX;
    private CommonEmptyView aCY;
    private View aCZ;
    private AlbumActivity aCi;
    private View aCo;
    private TextView aCp;
    private TextView aCq;
    private View aDa;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog aDb = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aBU != null) {
                if (view == ImageListFragment.this.aCU) {
                    ImageListFragment.this.aCV.b(ImageListFragment.this.aBU.AK(), ImageListFragment.this.aBU.AI());
                    ImageListFragment.this.aCV.R(ImageListFragment.this.aCZ);
                    ImageListFragment.this.aCU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aCo) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCU != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aCU.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aCJ = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aBU != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aBU.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aCi.cM(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0101a aDc = new a.InterfaceC0101a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0101a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.aBU != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aBU.AI()) && (ec = ImageListFragment.this.aBU.ec(albumId)) != null) {
                    ImageListFragment.this.aBU.ea(albumId);
                    ImageListFragment.this.aCX.setData(ec);
                    if (ImageListFragment.this.aCX.getCount() <= 0) {
                        ImageListFragment.this.aCY.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCY.setVisibility(8);
                    }
                    ImageListFragment.this.aCU.setText(name);
                    ImageListFragment.this.aCW.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aCK = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aCi == null || ImageListFragment.this.aBU == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aBU.AE()) {
                    ImageListFragment.this.aCi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aBU.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aCi.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aCi.a(imageFileInfo);
                }
                ImageListFragment.this.aBU.a((VideoFileInfo) null);
                ImageListFragment.this.aCX.notifyDataSetChanged();
                ImageListFragment.this.AN();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aBU.AD()) {
                    ImageListFragment.this.aCi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aBU.b(videoFileInfo)) {
                        ImageListFragment.this.aBU.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aBU.a(videoFileInfo);
                    }
                    ImageListFragment.this.aBU.AF();
                    ImageListFragment.this.aCX.notifyDataSetChanged();
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
        this.aCi = (AlbumActivity) getBaseFragmentActivity();
        this.aBU = this.aCi.Ao();
        d.AM().a(this);
        this.aCQ = new MediaStoreLoader(this.aCi);
        this.aCV = new com.baidu.live.tieba.write.a.a(this.aCi);
        this.aCV.setOnDismissListener(this.mOnDismissListener);
        this.aCV.a(this.aDc);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aCR = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aCZ = this.mView.findViewById(a.g.layout_title);
        this.aCU = (TextView) this.mView.findViewById(a.g.album_title);
        this.aCS = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aCT = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aDa = this.mView.findViewById(a.g.navi_line);
        this.aCo = this.mView.findViewById(a.g.layout_bottom);
        this.aCq = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aCp = (TextView) this.mView.findViewById(a.g.next_step);
        this.aBU.ea(AlbumData.ALBUM_ID_ALL);
        this.aCU.setText(this.aCi.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aCY = new CommonEmptyView(getContext());
        this.aCY.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aCY.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aCY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aCY.setVisibility(8);
        this.aCY.addToParent(this.aCR);
        this.aCW = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aCW.setSelector(a.d.sdk_transparent);
        this.aCX = new h(this.aCi, this.aBU);
        this.aCW.setAdapter((ListAdapter) this.aCX);
        this.aCW.setOuterOnScrollListener(this);
        this.aCX.a(this.aCK);
        this.aCX.a(this.aCJ);
        this.aCp.setOnClickListener(this.aCi);
        this.aCS.setOnClickListener(this.aCi);
        this.aCT.setOnClickListener(this.aCi);
        this.aCq.setOnClickListener(this.aCi);
        this.aCU.setOnClickListener(this.mOnClickListener);
        this.aCo.setOnClickListener(this.mOnClickListener);
        AN();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aDb == null) {
            this.aDb = new BlueCircleProgressDialog(getPageContext());
        }
        this.aDb.setCancelListener(null);
        this.aDb.setTipString(a.i.sdk_loading);
        this.aDb.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aCi.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        int count;
        String string;
        if (this.aBU != null && this.aCp != null) {
            if (this.aBU.AE()) {
                int i = this.aBU.AE() ? 1 : 0;
                count = i;
                string = this.aCi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aBU.AG());
                string = this.aCi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBU.getMaxImagesAllowed())});
            }
            this.aCp.setText(string);
            this.aCp.setEnabled(count > 0);
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
        if (this.aBU == null && this.aCi != null) {
            this.aBU = this.aCi.Ao();
        }
        if (this.aBU != null) {
            if (!this.aBU.AL()) {
                this.aCX.notifyDataSetChanged();
            } else {
                AO();
            }
            bt(this.aBU.isOriginalImg());
        }
    }

    private void AO() {
        if (this.aCQ == null) {
            this.aCQ = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aCQ.loadAll(this.aCi.An() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aDb != null) {
                    ImageListFragment.this.aDb.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aBU != null && resutMediaStore != null) {
                    ImageListFragment.this.aBU.a(resutMediaStore);
                    String AI = ImageListFragment.this.aBU.AI();
                    ImageListFragment.this.aBU.ea(AI);
                    ImageListFragment.this.aCX.setData(ImageListFragment.this.aBU.ec(AI));
                    if (ImageListFragment.this.aCX.getCount() <= 0) {
                        ImageListFragment.this.aCY.setVisibility(0);
                    } else {
                        ImageListFragment.this.aCY.setVisibility(8);
                    }
                    ImageListFragment.this.aCW.smoothScrollToPosition(0);
                    ImageListFragment.this.AN();
                }
                ImageListFragment.this.aCW.AQ();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aDa, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aCU, a.d.sdk_cp_cont_b, i);
        if (this.aCi.An() == 1) {
            SkinManager.setImageResource(this.aCS, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aCT.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aCT, a.d.sdk_ph_navi_back_text_color);
            this.aCS.setVisibility(8);
        }
        if (this.aCU != null) {
            this.aCU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aCX != null) {
            this.aCX.notifyDataSetChanged();
        }
        if (this.aBU != null) {
            bt(this.aBU.isOriginalImg());
        }
    }

    public View AA() {
        return this.aCi.An() == 1 ? this.aCS : this.aCT;
    }

    public View AP() {
        return this.aCp;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aCV != null) {
            this.aCV.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aCQ != null) {
            this.aCQ.cancelLoadTask();
        }
        if (this.aCi != null) {
            this.aCi.closeLoadingDialog();
        }
        if (this.aDb != null) {
            this.aDb.setDialogVisiable(false);
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
            this.aCX.bw(true);
        } else if (this.aCX.isScroll()) {
            this.aCX.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aCW != null) {
            int firstVisiblePosition = this.aCW.getFirstVisiblePosition();
            int lastVisiblePosition = this.aCW.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aCW.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aCX != null) {
                    this.aCX.b((ImageView) childAt.findViewById(a.g.select_icon), z);
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
        if (imageFileInfo != null && this.aCX != null) {
            i(this.aCX.e(imageFileInfo), z);
        }
    }

    public View Aw() {
        return this.aCq;
    }

    public void bt(boolean z) {
        if (this.aCi != null && this.aCq != null) {
            this.aCq.setText(this.aCi.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aCq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aCq, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aCq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aCq, a.d.sdk_cp_cont_f);
        }
    }
}
