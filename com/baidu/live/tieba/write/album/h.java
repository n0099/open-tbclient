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
    private ImageView aFv;
    private c bxI;
    private AlbumActivity bxW;
    private AlbumImagePagerAdapter bxX;
    private ImageView bxY;
    private View bxZ;
    private TextView bya;
    private TextView byb;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bxZ && view == h.this.bxY && h.this.bxX != null && h.this.bxI != null && h.this.bxW != null) {
                if (h.this.bxI.Ro()) {
                    h.this.bxW.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bxX.fL(h.this.mCurrentIndex)) {
                    ImageFileInfo fK = h.this.bxX.fK(h.this.mCurrentIndex);
                    if (h.this.bxI.isAdded(fK)) {
                        if (h.this.bxW.b(fK)) {
                            h.this.a(h.this.bxY, false);
                            h.this.bxW.a(fK, false);
                        }
                    } else if (h.this.bxW.a(fK)) {
                        h.this.a(h.this.bxY, true);
                        h.this.bxW.a(fK, true);
                    }
                    h.this.Rb();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.bxX != null && h.this.bxI != null) {
                ImageFileInfo fK = h.this.bxX.fK(h.this.mCurrentIndex);
                if (h.this.bxI.isAdded(fK)) {
                    h.this.a(h.this.bxY, true);
                } else {
                    h.this.a(h.this.bxY, false);
                }
                if (fK == null || !fK.isGif()) {
                    h.this.byb.setVisibility(0);
                } else {
                    h.this.byb.setVisibility(8);
                }
                h.this.cJ(h.this.bxI.isOriginalImg());
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
        this.bxW = albumActivity;
        this.bxI = this.bxW.QY();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bxW).inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aFv = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.bxY = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.bya = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.byb = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.bxZ = this.mRoot.findViewById(a.g.layout_bottom);
        this.aFv.setOnClickListener(this.bxW);
        this.bya.setOnClickListener(this.bxW);
        this.bxY.setOnClickListener(this.mOnClickListener);
        this.byb.setOnClickListener(this.bxW);
        this.bxZ.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb() {
        this.bxW.QV();
    }

    public void onResume() {
        Rd();
    }

    private void Rc() {
        List<ImageFileInfo> Rt;
        int currentIndex;
        if (this.bxI == null && this.bxW != null) {
            this.bxI = this.bxW.QY();
        }
        if (this.bxI != null && (Rt = this.bxI.Rt()) != null && (currentIndex = this.bxI.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bxX = new AlbumImagePagerAdapter(this.bxW);
            this.mViewPager.setAdapter(this.bxX);
            if (this.mCurrentIndex == 0 && Rt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Rt, this.mCurrentIndex);
                if (this.bxI.isAdded(imageFileInfo)) {
                    a(this.bxY, true);
                } else {
                    a(this.bxY, false);
                }
                if (imageFileInfo.isGif()) {
                    this.byb.setVisibility(8);
                } else {
                    this.byb.setVisibility(0);
                }
            }
            this.bxX.setData(Rt);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cJ(this.bxI.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View Rw() {
        return this.aFv;
    }

    public View Rx() {
        return this.bya;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aFv, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.bxI != null) {
            cJ(this.bxI.isOriginalImg());
        }
        if (this.bxX != null) {
            this.bxX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bxW != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.bya != null) {
                int count = this.bxI != null ? ListUtils.getCount(this.bxI.Rq()) : 0;
                this.bya.setText(this.bxW.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bxI != null ? this.bxI.getMaxImagesAllowed() : 1)}));
                this.bya.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo fK;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bxX != null && (fK = this.bxX.fK(this.mCurrentIndex)) != null && fK.getFilePath() != null && fK.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bxY, z);
        }
    }

    private void Rd() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        Rc();
    }

    public View Rj() {
        return this.byb;
    }

    public void cJ(boolean z) {
        long j;
        if (this.bxW != null && this.byb != null) {
            if (this.bxX != null) {
                ImageFileInfo fK = this.bxX.fK(this.mCurrentIndex);
                j = fK != null ? FileHelper.getFileSize(fK.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bxW.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_link_tip_a);
                this.byb.setText(sb2);
                this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_cont_f);
            this.byb.setText(string);
            this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
