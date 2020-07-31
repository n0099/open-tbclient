package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes4.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
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
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bjg && view == AlbumImageBrowseFragment.this.bjf && AlbumImageBrowseFragment.this.bje != null && AlbumImageBrowseFragment.this.biP != null && AlbumImageBrowseFragment.this.bjd != null) {
                if (AlbumImageBrowseFragment.this.biP.IS()) {
                    AlbumImageBrowseFragment.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bje.dw(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo dv = AlbumImageBrowseFragment.this.bje.dv(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.biP.isAdded(dv)) {
                        if (AlbumImageBrowseFragment.this.bjd.b(dv)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, false);
                            AlbumImageBrowseFragment.this.bjd.a(dv, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bjd.a(dv)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, true);
                        AlbumImageBrowseFragment.this.bjd.a(dv, true);
                    }
                    AlbumImageBrowseFragment.this.IF();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bje != null && AlbumImageBrowseFragment.this.biP != null) {
                ImageFileInfo dv = AlbumImageBrowseFragment.this.bje.dv(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.biP.isAdded(dv)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, false);
                }
                if (dv == null || !dv.isGif()) {
                    AlbumImageBrowseFragment.this.bji.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bji.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cp(AlbumImageBrowseFragment.this.biP.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bjd = (AlbumActivity) getBaseFragmentActivity();
        this.biP = this.bjd.IC();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
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
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        this.bjd.Iz();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            IH();
        }
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

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bje != null) {
            this.bje.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
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

    private void IH() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            IG();
        }
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
