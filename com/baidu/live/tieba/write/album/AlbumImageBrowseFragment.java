package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Wq;
    private AlbumImagePagerAdapter aCA;
    private ImageView aCB;
    private View aCC;
    private TextView aCD;
    private TextView aCE;
    private c aCi;
    private AlbumActivity aCw;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCC && view == AlbumImageBrowseFragment.this.aCB && AlbumImageBrowseFragment.this.aCA != null && AlbumImageBrowseFragment.this.aCi != null && AlbumImageBrowseFragment.this.aCw != null) {
                if (AlbumImageBrowseFragment.this.aCi.AL()) {
                    AlbumImageBrowseFragment.this.aCw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aCA.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cP = AlbumImageBrowseFragment.this.aCA.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aCi.isAdded(cP)) {
                        if (AlbumImageBrowseFragment.this.aCw.b(cP)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, false);
                            AlbumImageBrowseFragment.this.aCw.a(cP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aCw.a(cP)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, true);
                        AlbumImageBrowseFragment.this.aCw.a(cP, true);
                    }
                    AlbumImageBrowseFragment.this.AF();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.aCA != null && AlbumImageBrowseFragment.this.aCi != null) {
                ImageFileInfo cP = AlbumImageBrowseFragment.this.aCA.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aCi.isAdded(cP)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, false);
                }
                if (cP == null || !cP.isGif()) {
                    AlbumImageBrowseFragment.this.aCE.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCE.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bu(AlbumImageBrowseFragment.this.aCi.isOriginalImg());
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
        this.aCw = (AlbumActivity) getBaseFragmentActivity();
        this.aCi = this.aCw.Av();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Wq = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aCB = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aCD = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aCE = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aCC = this.mRoot.findViewById(a.g.layout_bottom);
        this.Wq.setOnClickListener(this.aCw);
        this.aCD.setOnClickListener(this.aCw);
        this.aCB.setOnClickListener(this.mOnClickListener);
        this.aCE.setOnClickListener(this.aCw);
        this.aCC.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF() {
        this.aCw.As();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AJ();
        }
    }

    private void AG() {
        List<ImageFileInfo> AQ;
        int currentIndex;
        if (this.aCi == null && this.aCw != null) {
            this.aCi = this.aCw.Av();
        }
        if (this.aCi != null && (AQ = this.aCi.AQ()) != null && (currentIndex = this.aCi.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aCA = new AlbumImagePagerAdapter(this.aCw);
            this.mViewPager.setAdapter(this.aCA);
            if (this.mCurrentIndex == 0 && AQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(AQ, this.mCurrentIndex);
                if (this.aCi.isAdded(imageFileInfo)) {
                    a(this.aCB, true);
                } else {
                    a(this.aCB, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aCE.setVisibility(8);
                } else {
                    this.aCE.setVisibility(0);
                }
            }
            this.aCA.setData(AQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bu(this.aCi.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aCA != null) {
            this.aCA.setData(null);
        }
    }

    public View AH() {
        return this.Wq;
    }

    public View AI() {
        return this.aCD;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Wq, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aCi != null) {
            bu(this.aCi.isOriginalImg());
        }
        if (this.aCA != null) {
            this.aCA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aCw != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aCD != null) {
                int count = this.aCi != null ? ListUtils.getCount(this.aCi.AN()) : 0;
                this.aCD.setText(this.aCw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aCi != null ? this.aCi.getMaxImagesAllowed() : 1)}));
                this.aCD.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aCA != null && (cP = this.aCA.cP(this.mCurrentIndex)) != null && cP.getFilePath() != null && cP.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCB, z);
        }
    }

    private void AJ() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            AG();
        }
    }

    public View AD() {
        return this.aCE;
    }

    public void bu(boolean z) {
        long j;
        if (this.aCw != null && this.aCE != null) {
            if (this.aCA != null) {
                ImageFileInfo cP = this.aCA.cP(this.mCurrentIndex);
                j = cP != null ? FileHelper.getFileSize(cP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aCw.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aCE, a.d.sdk_cp_link_tip_a);
                this.aCE.setText(sb2);
                this.aCE.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aCE, a.d.sdk_cp_cont_f);
            this.aCE.setText(string);
            this.aCE.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
