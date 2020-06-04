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
    private TextView bdA;
    private TextView bdB;
    private c bdi;
    private AlbumActivity bdw;
    private View bdz;
    private MediaStoreLoader bei;
    private RelativeLayout bej;
    private ImageView bek;
    private TextView bel;
    private TextView bem;
    private com.baidu.live.tieba.write.a.a ben;
    private TransparentHeadGridView beo;
    private i bep;
    private CommonEmptyView beq;
    private View ber;
    private View bes;
    private boolean beu;
    private View mView;
    private BlueCircleProgressDialog bev = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bdi != null) {
                if (view == ImageListFragment.this.bem) {
                    ImageListFragment.this.ben.b(ImageListFragment.this.bdi.HF(), ImageListFragment.this.bdi.HD());
                    ImageListFragment.this.ben.S(ImageListFragment.this.ber);
                    ImageListFragment.this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bdz) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bem != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bem.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bea = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bdi != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bdi.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bdw.dk(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0181a bew = new a.InterfaceC0181a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0181a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> fG;
            if (ImageListFragment.this.bdi != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bdi.HD()) && (fG = ImageListFragment.this.bdi.fG(albumId)) != null) {
                    ImageListFragment.this.bdi.fE(albumId);
                    ImageListFragment.this.bep.setData(fG);
                    if (ImageListFragment.this.bep.getCount() <= 0) {
                        ImageListFragment.this.beq.setVisibility(0);
                    } else {
                        ImageListFragment.this.beq.setVisibility(8);
                    }
                    ImageListFragment.this.bem.setText(name);
                    ImageListFragment.this.beo.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g beb = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bdw == null || ImageListFragment.this.bdi == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bdi.Hz()) {
                    ImageListFragment.this.bdw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bdi.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bdw.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bdw.a(imageFileInfo);
                }
                ImageListFragment.this.bdi.a((VideoFileInfo) null);
                ImageListFragment.this.bep.notifyDataSetChanged();
                ImageListFragment.this.HK();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bdi.Hy()) {
                    ImageListFragment.this.bdw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bdi.b(videoFileInfo)) {
                        ImageListFragment.this.bdi.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bdi.a(videoFileInfo);
                    }
                    ImageListFragment.this.bdi.HA();
                    ImageListFragment.this.bep.notifyDataSetChanged();
                    ImageListFragment.this.HK();
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
        this.bdw = (AlbumActivity) getBaseFragmentActivity();
        this.bdi = this.bdw.Hj();
        d.HH().a(this);
        this.bei = new MediaStoreLoader(this.bdw);
        this.ben = new com.baidu.live.tieba.write.a.a(this.bdw);
        this.ben.setOnDismissListener(this.mOnDismissListener);
        this.ben.a(this.bew);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bej = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.ber = this.mView.findViewById(a.g.layout_title);
        this.bem = (TextView) this.mView.findViewById(a.g.album_title);
        this.bek = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bel = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bes = this.mView.findViewById(a.g.navi_line);
        this.bdz = this.mView.findViewById(a.g.layout_bottom);
        this.bdB = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.bdA = (TextView) this.mView.findViewById(a.g.next_step);
        this.bdi.fE(AlbumData.ALBUM_ID_ALL);
        this.bem.setText(this.bdw.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.beq = new CommonEmptyView(getContext());
        this.beq.setTitle(a.i.sdk_ph_album_list_no_data);
        this.beq.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.beq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.beq.setVisibility(8);
        this.beq.addToParent(this.bej);
        this.beo = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.beo.setSelector(a.d.sdk_transparent);
        this.bep = new i(this.bdw, this.bdi);
        this.beo.setAdapter((ListAdapter) this.bep);
        this.beo.setOuterOnScrollListener(this);
        this.bep.a(this.beb);
        this.bep.a(this.bea);
        this.bdA.setOnClickListener(this.bdw);
        this.bek.setOnClickListener(this.bdw);
        this.bel.setOnClickListener(this.bdw);
        this.bdB.setOnClickListener(this.bdw);
        this.bem.setOnClickListener(this.mOnClickListener);
        this.bdz.setOnClickListener(this.mOnClickListener);
        HK();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bev == null) {
            this.bev = new BlueCircleProgressDialog(getPageContext());
        }
        this.bev.setCancelListener(null);
        this.bev.setTipString(a.i.sdk_loading);
        this.bev.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bdw.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        int count;
        String string;
        if (this.bdi != null && this.bdA != null) {
            if (this.bdi.Hz()) {
                int i = this.bdi.Hz() ? 1 : 0;
                count = i;
                string = this.bdw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bdi.HB());
                string = this.bdw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bdi.getMaxImagesAllowed())});
            }
            this.bdA.setText(string);
            this.bdA.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.beu = false;
        if (isShow()) {
            Ho();
        }
    }

    private void Hn() {
        if (this.bdi == null && this.bdw != null) {
            this.bdi = this.bdw.Hj();
        }
        if (this.bdi != null) {
            if (!this.bdi.HG()) {
                this.bep.notifyDataSetChanged();
            } else {
                HL();
            }
            ci(this.bdi.isOriginalImg());
        }
    }

    private void HL() {
        if (this.bei == null) {
            this.bei = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bei.loadAll(this.bdw.Hi() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bev != null) {
                    ImageListFragment.this.bev.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bdi != null && resutMediaStore != null) {
                    ImageListFragment.this.bdi.a(resutMediaStore);
                    String HD = ImageListFragment.this.bdi.HD();
                    ImageListFragment.this.bdi.fE(HD);
                    ImageListFragment.this.bep.setData(ImageListFragment.this.bdi.fG(HD));
                    if (ImageListFragment.this.bep.getCount() <= 0) {
                        ImageListFragment.this.beq.setVisibility(0);
                    } else {
                        ImageListFragment.this.beq.setVisibility(8);
                    }
                    ImageListFragment.this.beo.smoothScrollToPosition(0);
                    ImageListFragment.this.HK();
                }
                ImageListFragment.this.beo.HN();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bes, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bem, a.d.sdk_cp_cont_b, i);
        if (this.bdw.Hi() == 1) {
            SkinManager.setImageResource(this.bek, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bel.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bel, a.d.sdk_ph_navi_back_text_color);
            this.bek.setVisibility(8);
        }
        if (this.bem != null) {
            this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bep != null) {
            this.bep.notifyDataSetChanged();
        }
        if (this.bdi != null) {
            ci(this.bdi.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.ben != null) {
            this.ben.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bei != null) {
            this.bei.cancelLoadTask();
        }
        if (this.bdw != null) {
            this.bdw.closeLoadingDialog();
        }
        if (this.bev != null) {
            this.bev.setDialogVisiable(false);
        }
        d.HH().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.beu = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void ck(boolean z) {
        Ho();
    }

    private void Ho() {
        if (!isHidden() && !this.beu) {
            Hn();
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
            this.bep.cl(true);
        } else if (this.bep.isScroll()) {
            this.bep.cl(false);
        }
    }

    public void ci(boolean z) {
        if (this.bdw != null && this.bdB != null) {
            this.bdB.setText(this.bdw.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.bdB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bdB, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.bdB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bdB, a.d.sdk_cp_cont_f);
        }
    }
}
