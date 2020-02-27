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
    private ImageView Wg;
    private c aBS;
    private AlbumActivity aCg;
    private AlbumImagePagerAdapter aCk;
    private ImageView aCl;
    private View aCm;
    private TextView aCn;
    private TextView aCo;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCm && view == AlbumImageBrowseFragment.this.aCl && AlbumImageBrowseFragment.this.aCk != null && AlbumImageBrowseFragment.this.aBS != null && AlbumImageBrowseFragment.this.aCg != null) {
                if (AlbumImageBrowseFragment.this.aBS.AC()) {
                    AlbumImageBrowseFragment.this.aCg.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aCk.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cP = AlbumImageBrowseFragment.this.aCk.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aBS.isAdded(cP)) {
                        if (AlbumImageBrowseFragment.this.aCg.b(cP)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, false);
                            AlbumImageBrowseFragment.this.aCg.a(cP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aCg.a(cP)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, true);
                        AlbumImageBrowseFragment.this.aCg.a(cP, true);
                    }
                    AlbumImageBrowseFragment.this.Aw();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.aCk != null && AlbumImageBrowseFragment.this.aBS != null) {
                ImageFileInfo cP = AlbumImageBrowseFragment.this.aCk.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aBS.isAdded(cP)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, false);
                }
                if (cP == null || !cP.isGif()) {
                    AlbumImageBrowseFragment.this.aCo.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCo.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.aBS.isOriginalImg());
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
        this.aCg = (AlbumActivity) getBaseFragmentActivity();
        this.aBS = this.aCg.Am();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aCl = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aCn = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aCo = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aCm = this.mRoot.findViewById(a.g.layout_bottom);
        this.Wg.setOnClickListener(this.aCg);
        this.aCn.setOnClickListener(this.aCg);
        this.aCl.setOnClickListener(this.mOnClickListener);
        this.aCo.setOnClickListener(this.aCg);
        this.aCm.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        this.aCg.Aj();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AA();
        }
    }

    private void Ax() {
        List<ImageFileInfo> AH;
        int currentIndex;
        if (this.aBS == null && this.aCg != null) {
            this.aBS = this.aCg.Am();
        }
        if (this.aBS != null && (AH = this.aBS.AH()) != null && (currentIndex = this.aBS.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aCk = new AlbumImagePagerAdapter(this.aCg);
            this.mViewPager.setAdapter(this.aCk);
            if (this.mCurrentIndex == 0 && AH != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(AH, this.mCurrentIndex);
                if (this.aBS.isAdded(imageFileInfo)) {
                    a(this.aCl, true);
                } else {
                    a(this.aCl, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aCo.setVisibility(8);
                } else {
                    this.aCo.setVisibility(0);
                }
            }
            this.aCk.setData(AH);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.aBS.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aCk != null) {
            this.aCk.setData(null);
        }
    }

    public View Ay() {
        return this.Wg;
    }

    public View Az() {
        return this.aCn;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Wg, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aBS != null) {
            bt(this.aBS.isOriginalImg());
        }
        if (this.aCk != null) {
            this.aCk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aCg != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aCn != null) {
                int count = this.aBS != null ? ListUtils.getCount(this.aBS.AE()) : 0;
                this.aCn.setText(this.aCg.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBS != null ? this.aBS.getMaxImagesAllowed() : 1)}));
                this.aCn.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aCk != null && (cP = this.aCk.cP(this.mCurrentIndex)) != null && cP.getFilePath() != null && cP.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCl, z);
        }
    }

    private void AA() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Ax();
        }
    }

    public View Au() {
        return this.aCo;
    }

    public void bt(boolean z) {
        long j;
        if (this.aCg != null && this.aCo != null) {
            if (this.aCk != null) {
                ImageFileInfo cP = this.aCk.cP(this.mCurrentIndex);
                j = cP != null ? FileHelper.getFileSize(cP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aCg.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aCo, a.d.sdk_cp_link_tip_a);
                this.aCo.setText(sb2);
                this.aCo.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aCo, a.d.sdk_cp_cont_f);
            this.aCo.setText(string);
            this.aCo.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
