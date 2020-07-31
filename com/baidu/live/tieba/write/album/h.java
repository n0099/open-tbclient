package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
/* loaded from: classes4.dex */
public class h {
    private ImageView awy;
    private c biP;
    private AlbumActivity bjd;
    private AlbumImagePagerAdapter bje;
    private ImageView bjf;
    private View bjg;
    private TextView bjh;
    private TextView bji;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bjg && view == h.this.bjf && h.this.bje != null && h.this.biP != null && h.this.bjd != null) {
                if (h.this.biP.IS()) {
                    h.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bje.dw(h.this.mCurrentIndex)) {
                    ImageFileInfo dv = h.this.bje.dv(h.this.mCurrentIndex);
                    if (h.this.biP.isAdded(dv)) {
                        if (h.this.bjd.b(dv)) {
                            h.this.a(h.this.bjf, false);
                            h.this.bjd.a(dv, false);
                        }
                    } else if (h.this.bjd.a(dv)) {
                        h.this.a(h.this.bjf, true);
                        h.this.bjd.a(dv, true);
                    }
                    h.this.IF();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.bje != null && h.this.biP != null) {
                ImageFileInfo dv = h.this.bje.dv(h.this.mCurrentIndex);
                if (h.this.biP.isAdded(dv)) {
                    h.this.a(h.this.bjf, true);
                } else {
                    h.this.a(h.this.bjf, false);
                }
                if (dv == null || !dv.isGif()) {
                    h.this.bji.setVisibility(0);
                } else {
                    h.this.bji.setVisibility(8);
                }
                h.this.cp(h.this.biP.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public h(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.bjd = albumActivity;
        this.biP = this.bjd.IC();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bjd).inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.awy = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.bjf = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.bjh = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.bji = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.bjg = this.mRoot.findViewById(a.g.layout_bottom);
        this.awy.setOnClickListener(this.bjd);
        this.bjh.setOnClickListener(this.bjd);
        this.bjf.setOnClickListener(this.mOnClickListener);
        this.bji.setOnClickListener(this.bjd);
        this.bjg.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        this.bjd.Iz();
    }

    public void onResume() {
        IH();
    }

    private void IG() {
        List<ImageFileInfo> IX;
        int currentIndex;
        if (this.biP == null && this.bjd != null) {
            this.biP = this.bjd.IC();
        }
        if (this.biP != null && (IX = this.biP.IX()) != null && (currentIndex = this.biP.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bje = new AlbumImagePagerAdapter(this.bjd);
            this.mViewPager.setAdapter(this.bje);
            if (this.mCurrentIndex == 0 && IX != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(IX, this.mCurrentIndex);
                if (this.biP.isAdded(imageFileInfo)) {
                    a(this.bjf, true);
                } else {
                    a(this.bjf, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bji.setVisibility(8);
                } else {
                    this.bji.setVisibility(0);
                }
            }
            this.bje.setData(IX);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cp(this.biP.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View Jb() {
        return this.awy;
    }

    public View Jc() {
        return this.bjh;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.awy, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.biP != null) {
            cp(this.biP.isOriginalImg());
        }
        if (this.bje != null) {
            this.bje.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bjd != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.bjh != null) {
                int count = this.biP != null ? ListUtils.getCount(this.biP.IU()) : 0;
                this.bjh.setText(this.bjd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.biP != null ? this.biP.getMaxImagesAllowed() : 1)}));
                this.bjh.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo dv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bje != null && (dv = this.bje.dv(this.mCurrentIndex)) != null && dv.getFilePath() != null && dv.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bjf, z);
        }
    }

    private void IH() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        IG();
    }

    public View IN() {
        return this.bji;
    }

    public void cp(boolean z) {
        long j;
        if (this.bjd != null && this.bji != null) {
            if (this.bje != null) {
                ImageFileInfo dv = this.bje.dv(this.mCurrentIndex);
                j = dv != null ? FileHelper.getFileSize(dv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bjd.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bji, a.d.sdk_cp_link_tip_a);
                this.bji.setText(sb2);
                this.bji.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bji, a.d.sdk_cp_cont_f);
            this.bji.setText(string);
            this.bji.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
