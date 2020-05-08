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
    private c aVU;
    private AlbumActivity aWi;
    private AlbumImagePagerAdapter aWm;
    private ImageView aWn;
    private View aWo;
    private TextView aWp;
    private TextView aWq;
    private ImageView aox;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aWo && view == AlbumImageBrowseFragment.this.aWn && AlbumImageBrowseFragment.this.aWm != null && AlbumImageBrowseFragment.this.aVU != null && AlbumImageBrowseFragment.this.aWi != null) {
                if (AlbumImageBrowseFragment.this.aVU.FI()) {
                    AlbumImageBrowseFragment.this.aWi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aWm.df(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo de2 = AlbumImageBrowseFragment.this.aWm.de(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aVU.isAdded(de2)) {
                        if (AlbumImageBrowseFragment.this.aWi.b(de2)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, false);
                            AlbumImageBrowseFragment.this.aWi.a(de2, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aWi.a(de2)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, true);
                        AlbumImageBrowseFragment.this.aWi.a(de2, true);
                    }
                    AlbumImageBrowseFragment.this.FC();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.aWm != null && AlbumImageBrowseFragment.this.aVU != null) {
                ImageFileInfo de2 = AlbumImageBrowseFragment.this.aWm.de(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aVU.isAdded(de2)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, false);
                }
                if (de2 == null || !de2.isGif()) {
                    AlbumImageBrowseFragment.this.aWq.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aWq.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bY(AlbumImageBrowseFragment.this.aVU.isOriginalImg());
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
        this.aWi = (AlbumActivity) getBaseFragmentActivity();
        this.aVU = this.aWi.Fs();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aox = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aWn = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aWp = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aWq = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aWo = this.mRoot.findViewById(a.g.layout_bottom);
        this.aox.setOnClickListener(this.aWi);
        this.aWp.setOnClickListener(this.aWi);
        this.aWn.setOnClickListener(this.mOnClickListener);
        this.aWq.setOnClickListener(this.aWi);
        this.aWo.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        this.aWi.Fp();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            FG();
        }
    }

    private void FD() {
        List<ImageFileInfo> FN;
        int currentIndex;
        if (this.aVU == null && this.aWi != null) {
            this.aVU = this.aWi.Fs();
        }
        if (this.aVU != null && (FN = this.aVU.FN()) != null && (currentIndex = this.aVU.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aWm = new AlbumImagePagerAdapter(this.aWi);
            this.mViewPager.setAdapter(this.aWm);
            if (this.mCurrentIndex == 0 && FN != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(FN, this.mCurrentIndex);
                if (this.aVU.isAdded(imageFileInfo)) {
                    a(this.aWn, true);
                } else {
                    a(this.aWn, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aWq.setVisibility(8);
                } else {
                    this.aWq.setVisibility(0);
                }
            }
            this.aWm.setData(FN);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bY(this.aVU.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aWm != null) {
            this.aWm.setData(null);
        }
    }

    public View FE() {
        return this.aox;
    }

    public View FF() {
        return this.aWp;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aox, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aVU != null) {
            bY(this.aVU.isOriginalImg());
        }
        if (this.aWm != null) {
            this.aWm.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aWi != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aWp != null) {
                int count = this.aVU != null ? ListUtils.getCount(this.aVU.FK()) : 0;
                this.aWp.setText(this.aWi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aVU != null ? this.aVU.getMaxImagesAllowed() : 1)}));
                this.aWp.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo de2;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aWm != null && (de2 = this.aWm.de(this.mCurrentIndex)) != null && de2.getFilePath() != null && de2.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aWn, z);
        }
    }

    private void FG() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            FD();
        }
    }

    public View FA() {
        return this.aWq;
    }

    public void bY(boolean z) {
        long j;
        if (this.aWi != null && this.aWq != null) {
            if (this.aWm != null) {
                ImageFileInfo de2 = this.aWm.de(this.mCurrentIndex);
                j = de2 != null ? FileHelper.getFileSize(de2.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aWi.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aWq, a.d.sdk_cp_link_tip_a);
                this.aWq.setText(sb2);
                this.aWq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aWq, a.d.sdk_cp_cont_f);
            this.aWq.setText(string);
            this.aWq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
