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
    private c brG;
    private AlbumActivity brU;
    private View brX;
    private TextView brY;
    private TextView brZ;
    private MediaStoreLoader bsF;
    private RelativeLayout bsG;
    private ImageView bsH;
    private TextView bsI;
    private TextView bsJ;
    private com.baidu.live.tieba.write.a.a bsK;
    private TransparentHeadGridView bsL;
    private i bsM;
    private CommonEmptyView bsN;
    private View bsO;
    private View bsP;
    private boolean bsQ;
    private View mView;
    private BlueCircleProgressDialog bsR = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.brG != null) {
                if (view == ImageListFragment.this.bsJ) {
                    ImageListFragment.this.bsK.b(ImageListFragment.this.brG.Pu(), ImageListFragment.this.brG.Ps());
                    ImageListFragment.this.bsK.O(ImageListFragment.this.bsO);
                    ImageListFragment.this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.brX) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bsJ != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bsJ.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bsy = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.brG != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.brG.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.brU.fy(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0197a bsS = new a.InterfaceC0197a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0197a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hx;
            if (ImageListFragment.this.brG != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.brG.Ps()) && (hx = ImageListFragment.this.brG.hx(albumId)) != null) {
                    ImageListFragment.this.brG.hv(albumId);
                    ImageListFragment.this.bsM.setData(hx);
                    if (ImageListFragment.this.bsM.getCount() <= 0) {
                        ImageListFragment.this.bsN.setVisibility(0);
                    } else {
                        ImageListFragment.this.bsN.setVisibility(8);
                    }
                    ImageListFragment.this.bsJ.setText(name);
                    ImageListFragment.this.bsL.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bsz = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.brU == null || ImageListFragment.this.brG == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.brG.Po()) {
                    ImageListFragment.this.brU.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.brG.isAdded(imageFileInfo)) {
                    ImageListFragment.this.brU.b(imageFileInfo);
                } else {
                    ImageListFragment.this.brU.a(imageFileInfo);
                }
                ImageListFragment.this.brG.a((VideoFileInfo) null);
                ImageListFragment.this.bsM.notifyDataSetChanged();
                ImageListFragment.this.Py();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.brG.Pn()) {
                    ImageListFragment.this.brU.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.brG.b(videoFileInfo)) {
                        ImageListFragment.this.brG.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.brG.a(videoFileInfo);
                    }
                    ImageListFragment.this.brG.Pp();
                    ImageListFragment.this.bsM.notifyDataSetChanged();
                    ImageListFragment.this.Py();
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
        this.brU = (AlbumActivity) getBaseFragmentActivity();
        this.brG = this.brU.OY();
        d.Pv().a(this);
        this.bsF = new MediaStoreLoader(this.brU);
        this.bsK = new com.baidu.live.tieba.write.a.a(this.brU);
        this.bsK.setOnDismissListener(this.mOnDismissListener);
        this.bsK.a(this.bsS);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bsG = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bsO = this.mView.findViewById(a.g.layout_title);
        this.bsJ = (TextView) this.mView.findViewById(a.g.album_title);
        this.bsH = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bsI = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bsP = this.mView.findViewById(a.g.navi_line);
        this.brX = this.mView.findViewById(a.g.layout_bottom);
        this.brZ = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.brY = (TextView) this.mView.findViewById(a.g.next_step);
        this.brG.hv(AlbumData.ALBUM_ID_ALL);
        this.bsJ.setText(this.brU.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bsN = new CommonEmptyView(getContext());
        this.bsN.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bsN.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bsN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bsN.setVisibility(8);
        this.bsN.addToParent(this.bsG);
        this.bsL = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bsL.setSelector(a.d.sdk_transparent);
        this.bsM = new i(this.brU, this.brG);
        this.bsL.setAdapter((ListAdapter) this.bsM);
        this.bsL.setOuterOnScrollListener(this);
        this.bsM.a(this.bsz);
        this.bsM.a(this.bsy);
        this.brY.setOnClickListener(this.brU);
        this.bsH.setOnClickListener(this.brU);
        this.bsI.setOnClickListener(this.brU);
        this.brZ.setOnClickListener(this.brU);
        this.bsJ.setOnClickListener(this.mOnClickListener);
        this.brX.setOnClickListener(this.mOnClickListener);
        Py();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bsR == null) {
            this.bsR = new BlueCircleProgressDialog(getPageContext());
        }
        this.bsR.setCancelListener(null);
        this.bsR.setTipString(a.i.sdk_loading);
        this.bsR.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.brU.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py() {
        int count;
        String string;
        if (this.brG != null && this.brY != null) {
            if (this.brG.Po()) {
                int i = this.brG.Po() ? 1 : 0;
                count = i;
                string = this.brU.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.brG.Pq());
                string = this.brU.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.brG.getMaxImagesAllowed())});
            }
            this.brY.setText(string);
            this.brY.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bsQ = false;
        if (isShow()) {
            Pd();
        }
    }

    private void Pc() {
        if (this.brG == null && this.brU != null) {
            this.brG = this.brU.OY();
        }
        if (this.brG != null) {
            Pz();
            cA(this.brG.isOriginalImg());
        }
    }

    private void Pz() {
        if (this.bsF == null) {
            this.bsF = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bsF.loadAll(this.brU.OX() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bsR != null) {
                    ImageListFragment.this.bsR.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.brG != null && resutMediaStore != null) {
                    ImageListFragment.this.brG.a(resutMediaStore);
                    String Ps = ImageListFragment.this.brG.Ps();
                    ImageListFragment.this.brG.hv(Ps);
                    ImageListFragment.this.bsM.setData(ImageListFragment.this.brG.hx(Ps));
                    if (ImageListFragment.this.bsM.getCount() <= 0) {
                        ImageListFragment.this.bsN.setVisibility(0);
                    } else {
                        ImageListFragment.this.bsN.setVisibility(8);
                    }
                    ImageListFragment.this.bsL.smoothScrollToPosition(0);
                    ImageListFragment.this.Py();
                }
                ImageListFragment.this.bsL.PB();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bsP, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bsJ, a.d.sdk_cp_cont_b, i);
        if (this.brU.OX() == 1) {
            SkinManager.setImageResource(this.bsH, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bsI.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bsI, a.d.sdk_ph_navi_back_text_color);
            this.bsH.setVisibility(8);
        }
        if (this.bsJ != null) {
            this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bsM != null) {
            this.bsM.notifyDataSetChanged();
        }
        if (this.brG != null) {
            cA(this.brG.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bsK != null) {
            this.bsK.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bsF != null) {
            this.bsF.cancelLoadTask();
        }
        if (this.brU != null) {
            this.brU.closeLoadingDialog();
        }
        if (this.bsR != null) {
            this.bsR.setDialogVisiable(false);
        }
        d.Pv().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bsQ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cC(boolean z) {
        Pd();
    }

    private void Pd() {
        if (!isHidden() && !this.bsQ) {
            Pc();
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
            this.bsM.cD(true);
        } else if (this.bsM.isScroll()) {
            this.bsM.cD(false);
        }
    }

    public void cA(boolean z) {
        if (this.brU != null && this.brZ != null) {
            this.brZ.setText(this.brU.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_cont_f);
        }
    }
}
