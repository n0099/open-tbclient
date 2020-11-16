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
    private ImageView aEA;
    private TextView bCA;
    private TextView bCB;
    private c bCi;
    private AlbumActivity bCw;
    private AlbumImagePagerAdapter bCx;
    private ImageView bCy;
    private View bCz;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bCz && view == h.this.bCy && h.this.bCx != null && h.this.bCi != null && h.this.bCw != null) {
                if (h.this.bCi.Tn()) {
                    h.this.bCw.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bCx.fU(h.this.mCurrentIndex)) {
                    ImageFileInfo fT = h.this.bCx.fT(h.this.mCurrentIndex);
                    if (h.this.bCi.isAdded(fT)) {
                        if (h.this.bCw.b(fT)) {
                            h.this.a(h.this.bCy, false);
                            h.this.bCw.a(fT, false);
                        }
                    } else if (h.this.bCw.a(fT)) {
                        h.this.a(h.this.bCy, true);
                        h.this.bCw.a(fT, true);
                    }
                    h.this.Ta();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.bCx != null && h.this.bCi != null) {
                ImageFileInfo fT = h.this.bCx.fT(h.this.mCurrentIndex);
                if (h.this.bCi.isAdded(fT)) {
                    h.this.a(h.this.bCy, true);
                } else {
                    h.this.a(h.this.bCy, false);
                }
                if (fT == null || !fT.isGif()) {
                    h.this.bCB.setVisibility(0);
                } else {
                    h.this.bCB.setVisibility(8);
                }
                h.this.cS(h.this.bCi.isOriginalImg());
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
        this.bCw = albumActivity;
        this.bCi = this.bCw.SX();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bCw).inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aEA = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bCy = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bCA = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bCB = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bCz = this.mRoot.findViewById(a.f.layout_bottom);
        this.aEA.setOnClickListener(this.bCw);
        this.bCA.setOnClickListener(this.bCw);
        this.bCy.setOnClickListener(this.mOnClickListener);
        this.bCB.setOnClickListener(this.bCw);
        this.bCz.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        this.bCw.SU();
    }

    public void onResume() {
        Tc();
    }

    private void Tb() {
        List<ImageFileInfo> Ts;
        int currentIndex;
        if (this.bCi == null && this.bCw != null) {
            this.bCi = this.bCw.SX();
        }
        if (this.bCi != null && (Ts = this.bCi.Ts()) != null && (currentIndex = this.bCi.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bCx = new AlbumImagePagerAdapter(this.bCw);
            this.mViewPager.setAdapter(this.bCx);
            if (this.mCurrentIndex == 0 && Ts != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Ts, this.mCurrentIndex);
                if (this.bCi.isAdded(imageFileInfo)) {
                    a(this.bCy, true);
                } else {
                    a(this.bCy, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bCB.setVisibility(8);
                } else {
                    this.bCB.setVisibility(0);
                }
            }
            this.bCx.setData(Ts);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cS(this.bCi.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View Tv() {
        return this.aEA;
    }

    public View Tw() {
        return this.bCA;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aEA, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bCi != null) {
            cS(this.bCi.isOriginalImg());
        }
        if (this.bCx != null) {
            this.bCx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bCw != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bCA != null) {
                int count = this.bCi != null ? ListUtils.getCount(this.bCi.Tp()) : 0;
                this.bCA.setText(this.bCw.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bCi != null ? this.bCi.getMaxImagesAllowed() : 1)}));
                this.bCA.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo fT;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bCx != null && (fT = this.bCx.fT(this.mCurrentIndex)) != null && fT.getFilePath() != null && fT.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bCy, z);
        }
    }

    private void Tc() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        Tb();
    }

    public View Ti() {
        return this.bCB;
    }

    public void cS(boolean z) {
        long j;
        if (this.bCw != null && this.bCB != null) {
            if (this.bCx != null) {
                ImageFileInfo fT = this.bCx.fT(this.mCurrentIndex);
                j = fT != null ? FileHelper.getFileSize(fT.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bCw.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bCB, a.c.sdk_cp_link_tip_a);
                this.bCB.setText(sb2);
                this.bCB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bCB, a.c.sdk_cp_cont_f);
            this.bCB.setText(string);
            this.bCB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
