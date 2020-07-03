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
/* loaded from: classes3.dex */
public class h {
    private ImageView avt;
    private AlbumActivity biJ;
    private AlbumImagePagerAdapter biK;
    private ImageView biL;
    private View biM;
    private TextView biN;
    private TextView biO;
    private c biv;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.biM && view == h.this.biL && h.this.biK != null && h.this.biv != null && h.this.biJ != null) {
                if (h.this.biv.IM()) {
                    h.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (h.this.biK.dw(h.this.mCurrentIndex)) {
                    ImageFileInfo dv = h.this.biK.dv(h.this.mCurrentIndex);
                    if (h.this.biv.isAdded(dv)) {
                        if (h.this.biJ.b(dv)) {
                            h.this.a(h.this.biL, false);
                            h.this.biJ.a(dv, false);
                        }
                    } else if (h.this.biJ.a(dv)) {
                        h.this.a(h.this.biL, true);
                        h.this.biJ.a(dv, true);
                    }
                    h.this.Iz();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.biK != null && h.this.biv != null) {
                ImageFileInfo dv = h.this.biK.dv(h.this.mCurrentIndex);
                if (h.this.biv.isAdded(dv)) {
                    h.this.a(h.this.biL, true);
                } else {
                    h.this.a(h.this.biL, false);
                }
                if (dv == null || !dv.isGif()) {
                    h.this.biO.setVisibility(0);
                } else {
                    h.this.biO.setVisibility(8);
                }
                h.this.cn(h.this.biv.isOriginalImg());
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
        this.biJ = albumActivity;
        this.biv = this.biJ.Iw();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.biJ).inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.avt = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.biL = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.biN = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.biO = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.biM = this.mRoot.findViewById(a.g.layout_bottom);
        this.avt.setOnClickListener(this.biJ);
        this.biN.setOnClickListener(this.biJ);
        this.biL.setOnClickListener(this.mOnClickListener);
        this.biO.setOnClickListener(this.biJ);
        this.biM.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        this.biJ.It();
    }

    public void onResume() {
        IB();
    }

    private void IA() {
        List<ImageFileInfo> IR;
        int currentIndex;
        if (this.biv == null && this.biJ != null) {
            this.biv = this.biJ.Iw();
        }
        if (this.biv != null && (IR = this.biv.IR()) != null && (currentIndex = this.biv.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.biK = new AlbumImagePagerAdapter(this.biJ);
            this.mViewPager.setAdapter(this.biK);
            if (this.mCurrentIndex == 0 && IR != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(IR, this.mCurrentIndex);
                if (this.biv.isAdded(imageFileInfo)) {
                    a(this.biL, true);
                } else {
                    a(this.biL, false);
                }
                if (imageFileInfo.isGif()) {
                    this.biO.setVisibility(8);
                } else {
                    this.biO.setVisibility(0);
                }
            }
            this.biK.setData(IR);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cn(this.biv.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View IV() {
        return this.avt;
    }

    public View IW() {
        return this.biN;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.avt, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.biv != null) {
            cn(this.biv.isOriginalImg());
        }
        if (this.biK != null) {
            this.biK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.biJ != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.biN != null) {
                int count = this.biv != null ? ListUtils.getCount(this.biv.IO()) : 0;
                this.biN.setText(this.biJ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.biv != null ? this.biv.getMaxImagesAllowed() : 1)}));
                this.biN.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo dv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.biK != null && (dv = this.biK.dv(this.mCurrentIndex)) != null && dv.getFilePath() != null && dv.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.biL, z);
        }
    }

    private void IB() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        IA();
    }

    public View IH() {
        return this.biO;
    }

    public void cn(boolean z) {
        long j;
        if (this.biJ != null && this.biO != null) {
            if (this.biK != null) {
                ImageFileInfo dv = this.biK.dv(this.mCurrentIndex);
                j = dv != null ? FileHelper.getFileSize(dv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.biJ.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_link_tip_a);
                this.biO.setText(sb2);
                this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_cont_f);
            this.biO.setText(string);
            this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
