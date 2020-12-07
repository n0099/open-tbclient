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
/* loaded from: classes4.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private AlbumActivity bHE;
    private View bHH;
    private TextView bHI;
    private TextView bHJ;
    private c bHq;
    private boolean bIA;
    private MediaStoreLoader bIp;
    private RelativeLayout bIq;
    private ImageView bIr;
    private TextView bIs;
    private TextView bIt;
    private com.baidu.live.tieba.write.a.a bIu;
    private TransparentHeadGridView bIv;
    private i bIw;
    private CommonEmptyView bIx;
    private View bIy;
    private View bIz;
    private View mView;
    private BlueCircleProgressDialog bIB = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bHq != null) {
                if (view == ImageListFragment.this.bIt) {
                    ImageListFragment.this.bIu.c(ImageListFragment.this.bHq.VT(), ImageListFragment.this.bHq.VR());
                    ImageListFragment.this.bIu.O(ImageListFragment.this.bIy);
                    ImageListFragment.this.bIt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bHH) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bIt != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bIt.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bIi = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bHq != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bHq.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bHE.gr(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0227a bIC = new a.InterfaceC0227a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0227a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> iV;
            if (ImageListFragment.this.bHq != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bHq.VR()) && (iV = ImageListFragment.this.bHq.iV(albumId)) != null) {
                    ImageListFragment.this.bHq.iT(albumId);
                    ImageListFragment.this.bIw.setData(iV);
                    if (ImageListFragment.this.bIw.getCount() <= 0) {
                        ImageListFragment.this.bIx.setVisibility(0);
                    } else {
                        ImageListFragment.this.bIx.setVisibility(8);
                    }
                    ImageListFragment.this.bIt.setText(name);
                    ImageListFragment.this.bIv.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bIj = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bHE == null || ImageListFragment.this.bHq == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bHq.VN()) {
                    ImageListFragment.this.bHE.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bHq.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bHE.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bHE.a(imageFileInfo);
                }
                ImageListFragment.this.bHq.a((VideoFileInfo) null);
                ImageListFragment.this.bIw.notifyDataSetChanged();
                ImageListFragment.this.VX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bHq.VM()) {
                    ImageListFragment.this.bHE.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bHq.b(videoFileInfo)) {
                        ImageListFragment.this.bHq.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bHq.a(videoFileInfo);
                    }
                    ImageListFragment.this.bHq.VO();
                    ImageListFragment.this.bIw.notifyDataSetChanged();
                    ImageListFragment.this.VX();
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
        this.bHE = (AlbumActivity) getBaseFragmentActivity();
        this.bHq = this.bHE.Vx();
        d.VU().a(this);
        this.bIp = new MediaStoreLoader(this.bHE);
        this.bIu = new com.baidu.live.tieba.write.a.a(this.bHE);
        this.bIu.setOnDismissListener(this.mOnDismissListener);
        this.bIu.a(this.bIC);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bIq = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bIy = this.mView.findViewById(a.f.layout_title);
        this.bIt = (TextView) this.mView.findViewById(a.f.album_title);
        this.bIr = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bIs = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bIz = this.mView.findViewById(a.f.navi_line);
        this.bHH = this.mView.findViewById(a.f.layout_bottom);
        this.bHJ = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bHI = (TextView) this.mView.findViewById(a.f.next_step);
        this.bHq.iT(AlbumData.ALBUM_ID_ALL);
        this.bIt.setText(this.bHE.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bIx = new CommonEmptyView(getContext());
        this.bIx.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bIx.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bIx.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bIx.setVisibility(8);
        this.bIx.addToParent(this.bIq);
        this.bIv = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bIv.setSelector(a.c.sdk_transparent);
        this.bIw = new i(this.bHE, this.bHq);
        this.bIv.setAdapter((ListAdapter) this.bIw);
        this.bIv.setOuterOnScrollListener(this);
        this.bIw.a(this.bIj);
        this.bIw.a(this.bIi);
        this.bHI.setOnClickListener(this.bHE);
        this.bIr.setOnClickListener(this.bHE);
        this.bIs.setOnClickListener(this.bHE);
        this.bHJ.setOnClickListener(this.bHE);
        this.bIt.setOnClickListener(this.mOnClickListener);
        this.bHH.setOnClickListener(this.mOnClickListener);
        VX();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bIB == null) {
            this.bIB = new BlueCircleProgressDialog(getPageContext());
        }
        this.bIB.setCancelListener(null);
        this.bIB.setTipString(a.h.sdk_loading);
        this.bIB.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bHE.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        int count;
        String string;
        if (this.bHq != null && this.bHI != null) {
            if (this.bHq.VN()) {
                int i = this.bHq.VN() ? 1 : 0;
                count = i;
                string = this.bHE.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bHq.VP());
                string = this.bHE.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHq.getMaxImagesAllowed())});
            }
            this.bHI.setText(string);
            this.bHI.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bIA = false;
        if (isShow()) {
            VC();
        }
    }

    private void VB() {
        if (this.bHq == null && this.bHE != null) {
            this.bHq = this.bHE.Vx();
        }
        if (this.bHq != null) {
            VY();
            dg(this.bHq.isOriginalImg());
        }
    }

    private void VY() {
        if (this.bIp == null) {
            this.bIp = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bIp.loadAll(this.bHE.Vw() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bIB != null) {
                    ImageListFragment.this.bIB.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bHq != null && resutMediaStore != null) {
                    ImageListFragment.this.bHq.a(resutMediaStore);
                    String VR = ImageListFragment.this.bHq.VR();
                    ImageListFragment.this.bHq.iT(VR);
                    ImageListFragment.this.bIw.setData(ImageListFragment.this.bHq.iV(VR));
                    if (ImageListFragment.this.bIw.getCount() <= 0) {
                        ImageListFragment.this.bIx.setVisibility(0);
                    } else {
                        ImageListFragment.this.bIx.setVisibility(8);
                    }
                    ImageListFragment.this.bIv.smoothScrollToPosition(0);
                    ImageListFragment.this.VX();
                }
                ImageListFragment.this.bIv.Wa();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bIz, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bIt, a.c.sdk_cp_cont_b, i);
        if (this.bHE.Vw() == 1) {
            SkinManager.setImageResource(this.bIr, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bIs.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bIs, a.c.sdk_ph_navi_back_text_color);
            this.bIr.setVisibility(8);
        }
        if (this.bIt != null) {
            this.bIt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bIw != null) {
            this.bIw.notifyDataSetChanged();
        }
        if (this.bHq != null) {
            dg(this.bHq.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bIu != null) {
            this.bIu.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bIp != null) {
            this.bIp.cancelLoadTask();
        }
        if (this.bHE != null) {
            this.bHE.closeLoadingDialog();
        }
        if (this.bIB != null) {
            this.bIB.setDialogVisiable(false);
        }
        d.VU().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bIA = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void di(boolean z) {
        VC();
    }

    private void VC() {
        if (!isHidden() && !this.bIA) {
            VB();
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
            this.bIw.dj(true);
        } else if (this.bIw.isScroll()) {
            this.bIw.dj(false);
        }
    }

    public void dg(boolean z) {
        if (this.bHE != null && this.bHJ != null) {
            this.bHJ.setText(this.bHE.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bHJ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bHJ, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bHJ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bHJ, a.c.sdk_cp_cont_f);
        }
    }
}
