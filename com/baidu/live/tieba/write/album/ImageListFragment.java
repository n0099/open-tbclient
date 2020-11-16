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
    private TextView bCA;
    private TextView bCB;
    private c bCi;
    private AlbumActivity bCw;
    private View bCz;
    private MediaStoreLoader bDh;
    private RelativeLayout bDi;
    private ImageView bDj;
    private TextView bDk;
    private TextView bDl;
    private com.baidu.live.tieba.write.a.a bDm;
    private TransparentHeadGridView bDn;
    private i bDo;
    private CommonEmptyView bDp;
    private View bDq;
    private View bDr;
    private boolean bDs;
    private View mView;
    private BlueCircleProgressDialog bDt = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bCi != null) {
                if (view == ImageListFragment.this.bDl) {
                    ImageListFragment.this.bDm.c(ImageListFragment.this.bCi.Tt(), ImageListFragment.this.bCi.Tr());
                    ImageListFragment.this.bDm.O(ImageListFragment.this.bDq);
                    ImageListFragment.this.bDl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bCz) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bDl != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bDl.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bDa = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bCi != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bCi.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bCw.fS(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0218a bDu = new a.InterfaceC0218a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0218a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ir;
            if (ImageListFragment.this.bCi != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bCi.Tr()) && (ir = ImageListFragment.this.bCi.ir(albumId)) != null) {
                    ImageListFragment.this.bCi.ip(albumId);
                    ImageListFragment.this.bDo.setData(ir);
                    if (ImageListFragment.this.bDo.getCount() <= 0) {
                        ImageListFragment.this.bDp.setVisibility(0);
                    } else {
                        ImageListFragment.this.bDp.setVisibility(8);
                    }
                    ImageListFragment.this.bDl.setText(name);
                    ImageListFragment.this.bDn.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bDb = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bCw == null || ImageListFragment.this.bCi == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bCi.Tn()) {
                    ImageListFragment.this.bCw.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bCi.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bCw.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bCw.a(imageFileInfo);
                }
                ImageListFragment.this.bCi.a((VideoFileInfo) null);
                ImageListFragment.this.bDo.notifyDataSetChanged();
                ImageListFragment.this.Tx();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bCi.Tm()) {
                    ImageListFragment.this.bCw.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bCi.b(videoFileInfo)) {
                        ImageListFragment.this.bCi.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bCi.a(videoFileInfo);
                    }
                    ImageListFragment.this.bCi.To();
                    ImageListFragment.this.bDo.notifyDataSetChanged();
                    ImageListFragment.this.Tx();
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
        this.bCw = (AlbumActivity) getBaseFragmentActivity();
        this.bCi = this.bCw.SX();
        d.Tu().a(this);
        this.bDh = new MediaStoreLoader(this.bCw);
        this.bDm = new com.baidu.live.tieba.write.a.a(this.bCw);
        this.bDm.setOnDismissListener(this.mOnDismissListener);
        this.bDm.a(this.bDu);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bDi = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bDq = this.mView.findViewById(a.f.layout_title);
        this.bDl = (TextView) this.mView.findViewById(a.f.album_title);
        this.bDj = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bDk = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bDr = this.mView.findViewById(a.f.navi_line);
        this.bCz = this.mView.findViewById(a.f.layout_bottom);
        this.bCB = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bCA = (TextView) this.mView.findViewById(a.f.next_step);
        this.bCi.ip(AlbumData.ALBUM_ID_ALL);
        this.bDl.setText(this.bCw.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bDp = new CommonEmptyView(getContext());
        this.bDp.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bDp.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bDp.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bDp.setVisibility(8);
        this.bDp.addToParent(this.bDi);
        this.bDn = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bDn.setSelector(a.c.sdk_transparent);
        this.bDo = new i(this.bCw, this.bCi);
        this.bDn.setAdapter((ListAdapter) this.bDo);
        this.bDn.setOuterOnScrollListener(this);
        this.bDo.a(this.bDb);
        this.bDo.a(this.bDa);
        this.bCA.setOnClickListener(this.bCw);
        this.bDj.setOnClickListener(this.bCw);
        this.bDk.setOnClickListener(this.bCw);
        this.bCB.setOnClickListener(this.bCw);
        this.bDl.setOnClickListener(this.mOnClickListener);
        this.bCz.setOnClickListener(this.mOnClickListener);
        Tx();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bDt == null) {
            this.bDt = new BlueCircleProgressDialog(getPageContext());
        }
        this.bDt.setCancelListener(null);
        this.bDt.setTipString(a.h.sdk_loading);
        this.bDt.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bCw.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx() {
        int count;
        String string;
        if (this.bCi != null && this.bCA != null) {
            if (this.bCi.Tn()) {
                int i = this.bCi.Tn() ? 1 : 0;
                count = i;
                string = this.bCw.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bCi.Tp());
                string = this.bCw.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bCi.getMaxImagesAllowed())});
            }
            this.bCA.setText(string);
            this.bCA.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bDs = false;
        if (isShow()) {
            Tc();
        }
    }

    private void Tb() {
        if (this.bCi == null && this.bCw != null) {
            this.bCi = this.bCw.SX();
        }
        if (this.bCi != null) {
            Ty();
            cS(this.bCi.isOriginalImg());
        }
    }

    private void Ty() {
        if (this.bDh == null) {
            this.bDh = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bDh.loadAll(this.bCw.SW() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bDt != null) {
                    ImageListFragment.this.bDt.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bCi != null && resutMediaStore != null) {
                    ImageListFragment.this.bCi.a(resutMediaStore);
                    String Tr = ImageListFragment.this.bCi.Tr();
                    ImageListFragment.this.bCi.ip(Tr);
                    ImageListFragment.this.bDo.setData(ImageListFragment.this.bCi.ir(Tr));
                    if (ImageListFragment.this.bDo.getCount() <= 0) {
                        ImageListFragment.this.bDp.setVisibility(0);
                    } else {
                        ImageListFragment.this.bDp.setVisibility(8);
                    }
                    ImageListFragment.this.bDn.smoothScrollToPosition(0);
                    ImageListFragment.this.Tx();
                }
                ImageListFragment.this.bDn.TA();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bDr, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bDl, a.c.sdk_cp_cont_b, i);
        if (this.bCw.SW() == 1) {
            SkinManager.setImageResource(this.bDj, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bDk.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bDk, a.c.sdk_ph_navi_back_text_color);
            this.bDj.setVisibility(8);
        }
        if (this.bDl != null) {
            this.bDl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bDo != null) {
            this.bDo.notifyDataSetChanged();
        }
        if (this.bCi != null) {
            cS(this.bCi.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bDm != null) {
            this.bDm.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bDh != null) {
            this.bDh.cancelLoadTask();
        }
        if (this.bCw != null) {
            this.bCw.closeLoadingDialog();
        }
        if (this.bDt != null) {
            this.bDt.setDialogVisiable(false);
        }
        d.Tu().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bDs = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cU(boolean z) {
        Tc();
    }

    private void Tc() {
        if (!isHidden() && !this.bDs) {
            Tb();
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
            this.bDo.cV(true);
        } else if (this.bDo.isScroll()) {
            this.bDo.cV(false);
        }
    }

    public void cS(boolean z) {
        if (this.bCw != null && this.bCB != null) {
            this.bCB.setText(this.bCw.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bCB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bCB, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bCB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bCB, a.c.sdk_cp_cont_f);
        }
    }
}
