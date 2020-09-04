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
/* loaded from: classes7.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private AlbumActivity boL;
    private View boO;
    private TextView boP;
    private TextView boQ;
    private c box;
    private TextView bpA;
    private com.baidu.live.tieba.write.a.a bpB;
    private TransparentHeadGridView bpC;
    private i bpD;
    private CommonEmptyView bpE;
    private View bpF;
    private View bpG;
    private boolean bpH;
    private MediaStoreLoader bpw;
    private RelativeLayout bpx;
    private ImageView bpy;
    private TextView bpz;
    private View mView;
    private BlueCircleProgressDialog bpI = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.box != null) {
                if (view == ImageListFragment.this.bpA) {
                    ImageListFragment.this.bpB.b(ImageListFragment.this.box.OR(), ImageListFragment.this.box.OP());
                    ImageListFragment.this.bpB.O(ImageListFragment.this.bpF);
                    ImageListFragment.this.bpA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.boO) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bpA != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bpA.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bpp = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.box != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.box.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.boL.fn(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0197a bpJ = new a.InterfaceC0197a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0197a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hh;
            if (ImageListFragment.this.box != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.box.OP()) && (hh = ImageListFragment.this.box.hh(albumId)) != null) {
                    ImageListFragment.this.box.hf(albumId);
                    ImageListFragment.this.bpD.setData(hh);
                    if (ImageListFragment.this.bpD.getCount() <= 0) {
                        ImageListFragment.this.bpE.setVisibility(0);
                    } else {
                        ImageListFragment.this.bpE.setVisibility(8);
                    }
                    ImageListFragment.this.bpA.setText(name);
                    ImageListFragment.this.bpC.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bpq = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.boL == null || ImageListFragment.this.box == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.box.OL()) {
                    ImageListFragment.this.boL.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.box.isAdded(imageFileInfo)) {
                    ImageListFragment.this.boL.b(imageFileInfo);
                } else {
                    ImageListFragment.this.boL.a(imageFileInfo);
                }
                ImageListFragment.this.box.a((VideoFileInfo) null);
                ImageListFragment.this.bpD.notifyDataSetChanged();
                ImageListFragment.this.OV();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.box.OK()) {
                    ImageListFragment.this.boL.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.box.b(videoFileInfo)) {
                        ImageListFragment.this.box.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.box.a(videoFileInfo);
                    }
                    ImageListFragment.this.box.OM();
                    ImageListFragment.this.bpD.notifyDataSetChanged();
                    ImageListFragment.this.OV();
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
        this.boL = (AlbumActivity) getBaseFragmentActivity();
        this.box = this.boL.Ov();
        d.OS().a(this);
        this.bpw = new MediaStoreLoader(this.boL);
        this.bpB = new com.baidu.live.tieba.write.a.a(this.boL);
        this.bpB.setOnDismissListener(this.mOnDismissListener);
        this.bpB.a(this.bpJ);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bpx = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bpF = this.mView.findViewById(a.g.layout_title);
        this.bpA = (TextView) this.mView.findViewById(a.g.album_title);
        this.bpy = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bpz = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bpG = this.mView.findViewById(a.g.navi_line);
        this.boO = this.mView.findViewById(a.g.layout_bottom);
        this.boQ = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.boP = (TextView) this.mView.findViewById(a.g.next_step);
        this.box.hf(AlbumData.ALBUM_ID_ALL);
        this.bpA.setText(this.boL.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bpE = new CommonEmptyView(getContext());
        this.bpE.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bpE.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bpE.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bpE.setVisibility(8);
        this.bpE.addToParent(this.bpx);
        this.bpC = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bpC.setSelector(a.d.sdk_transparent);
        this.bpD = new i(this.boL, this.box);
        this.bpC.setAdapter((ListAdapter) this.bpD);
        this.bpC.setOuterOnScrollListener(this);
        this.bpD.a(this.bpq);
        this.bpD.a(this.bpp);
        this.boP.setOnClickListener(this.boL);
        this.bpy.setOnClickListener(this.boL);
        this.bpz.setOnClickListener(this.boL);
        this.boQ.setOnClickListener(this.boL);
        this.bpA.setOnClickListener(this.mOnClickListener);
        this.boO.setOnClickListener(this.mOnClickListener);
        OV();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bpI == null) {
            this.bpI = new BlueCircleProgressDialog(getPageContext());
        }
        this.bpI.setCancelListener(null);
        this.bpI.setTipString(a.i.sdk_loading);
        this.bpI.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.boL.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        int count;
        String string;
        if (this.box != null && this.boP != null) {
            if (this.box.OL()) {
                int i = this.box.OL() ? 1 : 0;
                count = i;
                string = this.boL.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.box.ON());
                string = this.boL.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.box.getMaxImagesAllowed())});
            }
            this.boP.setText(string);
            this.boP.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpH = false;
        if (isShow()) {
            OA();
        }
    }

    private void Oz() {
        if (this.box == null && this.boL != null) {
            this.box = this.boL.Ov();
        }
        if (this.box != null) {
            OW();
            cz(this.box.isOriginalImg());
        }
    }

    private void OW() {
        if (this.bpw == null) {
            this.bpw = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bpw.loadAll(this.boL.Ou() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bpI != null) {
                    ImageListFragment.this.bpI.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.box != null && resutMediaStore != null) {
                    ImageListFragment.this.box.a(resutMediaStore);
                    String OP = ImageListFragment.this.box.OP();
                    ImageListFragment.this.box.hf(OP);
                    ImageListFragment.this.bpD.setData(ImageListFragment.this.box.hh(OP));
                    if (ImageListFragment.this.bpD.getCount() <= 0) {
                        ImageListFragment.this.bpE.setVisibility(0);
                    } else {
                        ImageListFragment.this.bpE.setVisibility(8);
                    }
                    ImageListFragment.this.bpC.smoothScrollToPosition(0);
                    ImageListFragment.this.OV();
                }
                ImageListFragment.this.bpC.OY();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bpG, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bpA, a.d.sdk_cp_cont_b, i);
        if (this.boL.Ou() == 1) {
            SkinManager.setImageResource(this.bpy, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bpz.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bpz, a.d.sdk_ph_navi_back_text_color);
            this.bpy.setVisibility(8);
        }
        if (this.bpA != null) {
            this.bpA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bpD != null) {
            this.bpD.notifyDataSetChanged();
        }
        if (this.box != null) {
            cz(this.box.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bpB != null) {
            this.bpB.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bpw != null) {
            this.bpw.cancelLoadTask();
        }
        if (this.boL != null) {
            this.boL.closeLoadingDialog();
        }
        if (this.bpI != null) {
            this.bpI.setDialogVisiable(false);
        }
        d.OS().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bpH = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cB(boolean z) {
        OA();
    }

    private void OA() {
        if (!isHidden() && !this.bpH) {
            Oz();
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
            this.bpD.cC(true);
        } else if (this.bpD.isScroll()) {
            this.bpD.cC(false);
        }
    }

    public void cz(boolean z) {
        if (this.boL != null && this.boQ != null) {
            this.boQ.setText(this.boL.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.boQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.boQ, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.boQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.boQ, a.d.sdk_cp_cont_f);
        }
    }
}
