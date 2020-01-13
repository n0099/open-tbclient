package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Uw;
    private c axC;
    private AlbumActivity axQ;
    private AlbumImagePagerAdapter axU;
    private ImageView axV;
    private View axW;
    private TextView axX;
    private TextView axY;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.axW && view == AlbumImageBrowseFragment.this.axV && AlbumImageBrowseFragment.this.axU != null && AlbumImageBrowseFragment.this.axC != null && AlbumImageBrowseFragment.this.axQ != null) {
                if (AlbumImageBrowseFragment.this.axC.yl()) {
                    AlbumImageBrowseFragment.this.axQ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.axU.cA(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cz = AlbumImageBrowseFragment.this.axU.cz(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.axC.isAdded(cz)) {
                        if (AlbumImageBrowseFragment.this.axQ.b(cz)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                            AlbumImageBrowseFragment.this.axQ.a(cz, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.axQ.a(cz)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                        AlbumImageBrowseFragment.this.axQ.a(cz, true);
                    }
                    AlbumImageBrowseFragment.this.yf();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.axU != null && AlbumImageBrowseFragment.this.axC != null) {
                ImageFileInfo cz = AlbumImageBrowseFragment.this.axU.cz(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.axC.isAdded(cz)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                }
                if (cz == null || !cz.isGif()) {
                    AlbumImageBrowseFragment.this.axY.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.axY.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bl(AlbumImageBrowseFragment.this.axC.isOriginalImg());
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
        this.axQ = (AlbumActivity) getBaseFragmentActivity();
        this.axC = this.axQ.xV();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Uw = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.axV = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.axX = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.axY = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.axW = this.mRoot.findViewById(a.g.layout_bottom);
        this.Uw.setOnClickListener(this.axQ);
        this.axX.setOnClickListener(this.axQ);
        this.axV.setOnClickListener(this.mOnClickListener);
        this.axY.setOnClickListener(this.axQ);
        this.axW.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf() {
        this.axQ.xS();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            yj();
        }
    }

    private void yg() {
        List<ImageFileInfo> yq;
        int currentIndex;
        if (this.axC == null && this.axQ != null) {
            this.axC = this.axQ.xV();
        }
        if (this.axC != null && (yq = this.axC.yq()) != null && (currentIndex = this.axC.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.axU = new AlbumImagePagerAdapter(this.axQ);
            this.mViewPager.setAdapter(this.axU);
            if (this.mCurrentIndex == 0 && yq != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(yq, this.mCurrentIndex);
                if (this.axC.isAdded(imageFileInfo)) {
                    a(this.axV, true);
                } else {
                    a(this.axV, false);
                }
                if (imageFileInfo.isGif()) {
                    this.axY.setVisibility(8);
                } else {
                    this.axY.setVisibility(0);
                }
            }
            this.axU.setData(yq);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bl(this.axC.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.axU != null) {
            this.axU.setData(null);
        }
    }

    public View yh() {
        return this.Uw;
    }

    public View yi() {
        return this.axX;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Uw, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.axC != null) {
            bl(this.axC.isOriginalImg());
        }
        if (this.axU != null) {
            this.axU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.axQ != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.axX != null) {
                int count = this.axC != null ? ListUtils.getCount(this.axC.yn()) : 0;
                this.axX.setText(this.axQ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.axC != null ? this.axC.getMaxImagesAllowed() : 1)}));
                this.axX.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cz;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.axU != null && (cz = this.axU.cz(this.mCurrentIndex)) != null && cz.getFilePath() != null && cz.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.axV, z);
        }
    }

    private void yj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            yg();
        }
    }

    public View yd() {
        return this.axY;
    }

    public void bl(boolean z) {
        long j;
        if (this.axQ != null && this.axY != null) {
            if (this.axU != null) {
                ImageFileInfo cz = this.axU.cz(this.mCurrentIndex);
                j = cz != null ? FileHelper.getFileSize(cz.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.axQ.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.axY, a.d.sdk_cp_link_tip_a);
                this.axY.setText(sb2);
                this.axY.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.axY, a.d.sdk_cp_cont_f);
            this.axY.setText(string);
            this.axY.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
