package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes11.dex */
public class h {
    private ViewPager Zk;
    private ImageView aHx;
    private c bMd;
    private AlbumActivity bMr;
    private AlbumImagePagerAdapter bMs;
    private ImageView bMt;
    private View bMu;
    private TextView bMv;
    private TextView bMw;
    private View mNoDataView;
    private View mRoot;
    private TbPageContext tbPageContext;
    private int bMx = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bMu && view == h.this.bMt && h.this.bMs != null && h.this.bMd != null && h.this.bMr != null) {
                if (h.this.bMd.WP()) {
                    h.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bMs.gu(h.this.bMx)) {
                    ImageFileInfo gt = h.this.bMs.gt(h.this.bMx);
                    if (h.this.bMd.isAdded(gt)) {
                        if (h.this.bMr.b(gt)) {
                            h.this.a(h.this.bMt, false);
                            h.this.bMr.a(gt, false);
                        }
                    } else if (h.this.bMr.a(gt)) {
                        h.this.a(h.this.bMt, true);
                        h.this.bMr.a(gt, true);
                    }
                    h.this.WC();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.bMx = i;
            if (h.this.bMs != null && h.this.bMd != null) {
                ImageFileInfo gt = h.this.bMs.gt(h.this.bMx);
                if (h.this.bMd.isAdded(gt)) {
                    h.this.a(h.this.bMt, true);
                } else {
                    h.this.a(h.this.bMt, false);
                }
                if (gt == null || !gt.isGif()) {
                    h.this.bMw.setVisibility(0);
                } else {
                    h.this.bMw.setVisibility(8);
                }
                h.this.dj(h.this.bMd.isOriginalImg());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public h(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.bMr = albumActivity;
        this.bMd = this.bMr.Wz();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bMr).inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aHx = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bMt = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Zk = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bMv = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bMw = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bMu = this.mRoot.findViewById(a.f.layout_bottom);
        this.aHx.setOnClickListener(this.bMr);
        this.bMv.setOnClickListener(this.bMr);
        this.bMt.setOnClickListener(this.mOnClickListener);
        this.bMw.setOnClickListener(this.bMr);
        this.bMu.setOnClickListener(this.mOnClickListener);
        this.Zk.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        this.bMr.Ww();
    }

    public void onResume() {
        WE();
    }

    private void WD() {
        List<ImageFileInfo> WU;
        int currentIndex;
        if (this.bMd == null && this.bMr != null) {
            this.bMd = this.bMr.Wz();
        }
        if (this.bMd != null && (WU = this.bMd.WU()) != null && (currentIndex = this.bMd.getCurrentIndex()) >= 0) {
            this.bMx = currentIndex;
            this.bMs = new AlbumImagePagerAdapter(this.bMr);
            this.Zk.setAdapter(this.bMs);
            if (this.bMx == 0 && WU != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(WU, this.bMx);
                if (this.bMd.isAdded(imageFileInfo)) {
                    a(this.bMt, true);
                } else {
                    a(this.bMt, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bMw.setVisibility(8);
                } else {
                    this.bMw.setVisibility(0);
                }
            }
            this.bMs.setData(WU);
            this.Zk.setCurrentItem(this.bMx, false);
            dj(this.bMd.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View WX() {
        return this.aHx;
    }

    public View WY() {
        return this.bMv;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aHx, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bMd != null) {
            dj(this.bMd.isOriginalImg());
        }
        if (this.bMs != null) {
            this.bMs.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bMr != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bMv != null) {
                int count = this.bMd != null ? ListUtils.getCount(this.bMd.WR()) : 0;
                this.bMv.setText(this.bMr.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMd != null ? this.bMd.getMaxImagesAllowed() : 1)}));
                this.bMv.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo gt;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bMs != null && (gt = this.bMs.gt(this.bMx)) != null && gt.getFilePath() != null && gt.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bMt, z);
        }
    }

    private void WE() {
        this.mNoDataView.setVisibility(8);
        this.Zk.setVisibility(0);
        WD();
    }

    public View WK() {
        return this.bMw;
    }

    public void dj(boolean z) {
        long j;
        if (this.bMr != null && this.bMw != null) {
            if (this.bMs != null) {
                ImageFileInfo gt = this.bMs.gt(this.bMx);
                j = gt != null ? FileHelper.getFileSize(gt.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bMr.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_link_tip_a);
                this.bMw.setText(sb2);
                this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_cont_f);
            this.bMw.setText(string);
            this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
