package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.MediaStoreLoadCallback;
import com.baidu.live.tbadk.album.MediaStoreLoader;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
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
public class j implements AbsListView.OnScrollListener, d.a {
    private AlbumActivity boI;
    private View boL;
    private TextView boM;
    private TextView boN;
    private c bou;
    private i bpA;
    private CommonEmptyView bpB;
    private View bpC;
    private View bpD;
    private boolean bpE;
    private MediaStoreLoader bpt;
    private RelativeLayout bpu;
    private ImageView bpv;
    private TextView bpw;
    private TextView bpx;
    private com.baidu.live.tieba.write.a.a bpy;
    private TransparentHeadGridView bpz;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bpF = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bou != null) {
                if (view == j.this.bpx) {
                    j.this.bpy.b(j.this.bou.OR(), j.this.bou.OP());
                    j.this.bpy.O(j.this.bpC);
                    j.this.bpx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.boL) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bpx != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bpx.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bpm = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bou != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bou.d((ImageFileInfo) mediaFileInfo);
                    j.this.boI.fn(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0197a bpG = new a.InterfaceC0197a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0197a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hg;
            if (j.this.bou != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bou.OP()) && (hg = j.this.bou.hg(albumId)) != null) {
                    j.this.bou.he(albumId);
                    j.this.bpA.setData(hg);
                    if (j.this.bpA.getCount() <= 0) {
                        j.this.bpB.setVisibility(0);
                    } else {
                        j.this.bpB.setVisibility(8);
                    }
                    j.this.bpx.setText(name);
                    j.this.bpz.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bpn = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.boI == null || j.this.bou == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bou.OL()) {
                    j.this.boI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bou.isAdded(imageFileInfo)) {
                    j.this.boI.b(imageFileInfo);
                } else {
                    j.this.boI.a(imageFileInfo);
                }
                j.this.bou.a((VideoFileInfo) null);
                j.this.bpA.notifyDataSetChanged();
                j.this.OV();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bou.OK()) {
                    j.this.boI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bou.b(videoFileInfo)) {
                        j.this.bou.a((VideoFileInfo) null);
                    } else {
                        j.this.bou.a(videoFileInfo);
                    }
                    j.this.bou.OM();
                    j.this.bpA.notifyDataSetChanged();
                    j.this.OV();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    public j(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.boI = albumActivity;
        this.bou = this.boI.Ov();
        d.OS().a(this);
        this.bpt = new MediaStoreLoader(this.boI);
        this.bpy = new com.baidu.live.tieba.write.a.a(this.boI);
        this.bpy.setOnDismissListener(this.mOnDismissListener);
        this.bpy.a(this.bpG);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.boI).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bpu = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bpC = this.mView.findViewById(a.g.layout_title);
        this.bpx = (TextView) this.mView.findViewById(a.g.album_title);
        this.bpv = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bpw = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bpD = this.mView.findViewById(a.g.navi_line);
        this.boL = this.mView.findViewById(a.g.layout_bottom);
        this.boN = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.boM = (TextView) this.mView.findViewById(a.g.next_step);
        this.bou.he(AlbumData.ALBUM_ID_ALL);
        this.bpx.setText(this.boI.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bpB = new CommonEmptyView(this.boI);
        this.bpB.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bpB.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bpB.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bpB.setVisibility(8);
        this.bpB.addToParent(this.bpu);
        this.bpz = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bpz.setSelector(a.d.sdk_transparent);
        this.bpA = new i(this.boI, this.bou);
        this.bpz.setAdapter((ListAdapter) this.bpA);
        this.bpz.setOuterOnScrollListener(this);
        this.bpA.a(this.bpn);
        this.bpA.a(this.bpm);
        this.boM.setOnClickListener(this.boI);
        this.bpv.setOnClickListener(this.boI);
        this.bpw.setOnClickListener(this.boI);
        this.boN.setOnClickListener(this.boI);
        this.bpx.setOnClickListener(this.mOnClickListener);
        this.boL.setOnClickListener(this.mOnClickListener);
        OV();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bpF == null) {
            this.bpF = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bpF.setCancelListener(null);
        this.bpF.setTipString(a.i.sdk_loading);
        this.bpF.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.boI.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        int count;
        String string;
        if (this.bou != null && this.boM != null) {
            if (this.bou.OL()) {
                int i = this.bou.OL() ? 1 : 0;
                count = i;
                string = this.boI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bou.ON());
                string = this.boI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bou.getMaxImagesAllowed())});
            }
            this.boM.setText(string);
            this.boM.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.bpE = false;
        OA();
    }

    private void Oz() {
        if (this.bou == null && this.boI != null) {
            this.bou = this.boI.Ov();
        }
        if (this.bou != null) {
            OW();
            cy(this.bou.isOriginalImg());
        }
    }

    private void OW() {
        if (this.bpt == null) {
            this.bpt = new MediaStoreLoader(this.boI);
        }
        this.bpt.loadAll(this.boI.Ou() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bpF != null) {
                    j.this.bpF.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bou != null && resutMediaStore != null) {
                    j.this.bou.a(resutMediaStore);
                    String OP = j.this.bou.OP();
                    j.this.bou.he(OP);
                    j.this.bpA.setData(j.this.bou.hg(OP));
                    if (j.this.bpA.getCount() <= 0) {
                        j.this.bpB.setVisibility(0);
                    } else {
                        j.this.bpB.setVisibility(8);
                    }
                    j.this.bpz.smoothScrollToPosition(0);
                    j.this.OV();
                }
                j.this.bpz.OY();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bpD, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bpx, a.d.sdk_cp_cont_b, i);
        if (this.boI.Ou() == 1) {
            SkinManager.setImageResource(this.bpv, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bpw.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bpw, a.d.sdk_ph_navi_back_text_color);
            this.bpv.setVisibility(8);
        }
        if (this.bpx != null) {
            this.bpx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bpA != null) {
            this.bpA.notifyDataSetChanged();
        }
        if (this.bou != null) {
            cy(this.bou.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View OT() {
        return this.boI.Ou() == 1 ? this.bpv : this.bpw;
    }

    public View OX() {
        return this.boM;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cA(boolean z) {
        OA();
    }

    private void OA() {
        if (!this.bpE) {
            Oz();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bpA.cB(true);
        } else if (this.bpA.isScroll()) {
            this.bpA.cB(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bpz != null) {
            int firstVisiblePosition = this.bpz.getFirstVisiblePosition();
            int lastVisiblePosition = this.bpz.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bpz.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bpA != null) {
                    this.bpA.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        OV();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bpA != null) {
            o(this.bpA.e(imageFileInfo), z);
        }
    }

    public View OG() {
        return this.boN;
    }

    public void cy(boolean z) {
        if (this.boI != null && this.boN != null) {
            this.boN.setText(this.boI.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.boN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.boN, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.boN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.boN, a.d.sdk_cp_cont_f);
        }
    }
}
