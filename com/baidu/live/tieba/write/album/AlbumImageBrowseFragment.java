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
    private c aBT;
    private AlbumActivity aCh;
    private AlbumImagePagerAdapter aCl;
    private ImageView aCm;
    private View aCn;
    private TextView aCo;
    private TextView aCp;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCn && view == AlbumImageBrowseFragment.this.aCm && AlbumImageBrowseFragment.this.aCl != null && AlbumImageBrowseFragment.this.aBT != null && AlbumImageBrowseFragment.this.aCh != null) {
                if (AlbumImageBrowseFragment.this.aBT.AE()) {
                    AlbumImageBrowseFragment.this.aCh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aCl.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cP = AlbumImageBrowseFragment.this.aCl.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aBT.isAdded(cP)) {
                        if (AlbumImageBrowseFragment.this.aCh.b(cP)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, false);
                            AlbumImageBrowseFragment.this.aCh.a(cP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aCh.a(cP)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, true);
                        AlbumImageBrowseFragment.this.aCh.a(cP, true);
                    }
                    AlbumImageBrowseFragment.this.Ay();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.aCl != null && AlbumImageBrowseFragment.this.aBT != null) {
                ImageFileInfo cP = AlbumImageBrowseFragment.this.aCl.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aBT.isAdded(cP)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, false);
                }
                if (cP == null || !cP.isGif()) {
                    AlbumImageBrowseFragment.this.aCp.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCp.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.aBT.isOriginalImg());
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
        this.aCh = (AlbumActivity) getBaseFragmentActivity();
        this.aBT = this.aCh.Ao();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aCm = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aCo = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aCp = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aCn = this.mRoot.findViewById(a.g.layout_bottom);
        this.Wg.setOnClickListener(this.aCh);
        this.aCo.setOnClickListener(this.aCh);
        this.aCm.setOnClickListener(this.mOnClickListener);
        this.aCp.setOnClickListener(this.aCh);
        this.aCn.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        this.aCh.Al();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AC();
        }
    }

    private void Az() {
        List<ImageFileInfo> AJ;
        int currentIndex;
        if (this.aBT == null && this.aCh != null) {
            this.aBT = this.aCh.Ao();
        }
        if (this.aBT != null && (AJ = this.aBT.AJ()) != null && (currentIndex = this.aBT.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aCl = new AlbumImagePagerAdapter(this.aCh);
            this.mViewPager.setAdapter(this.aCl);
            if (this.mCurrentIndex == 0 && AJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(AJ, this.mCurrentIndex);
                if (this.aBT.isAdded(imageFileInfo)) {
                    a(this.aCm, true);
                } else {
                    a(this.aCm, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aCp.setVisibility(8);
                } else {
                    this.aCp.setVisibility(0);
                }
            }
            this.aCl.setData(AJ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.aBT.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aCl != null) {
            this.aCl.setData(null);
        }
    }

    public View AA() {
        return this.Wg;
    }

    public View AB() {
        return this.aCo;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Wg, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aBT != null) {
            bt(this.aBT.isOriginalImg());
        }
        if (this.aCl != null) {
            this.aCl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aCh != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aCo != null) {
                int count = this.aBT != null ? ListUtils.getCount(this.aBT.AG()) : 0;
                this.aCo.setText(this.aCh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBT != null ? this.aBT.getMaxImagesAllowed() : 1)}));
                this.aCo.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aCl != null && (cP = this.aCl.cP(this.mCurrentIndex)) != null && cP.getFilePath() != null && cP.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCm, z);
        }
    }

    private void AC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Az();
        }
    }

    public View Aw() {
        return this.aCp;
    }

    public void bt(boolean z) {
        long j;
        if (this.aCh != null && this.aCp != null) {
            if (this.aCl != null) {
                ImageFileInfo cP = this.aCl.cP(this.mCurrentIndex);
                j = cP != null ? FileHelper.getFileSize(cP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aCh.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aCp, a.d.sdk_cp_link_tip_a);
                this.aCp.setText(sb2);
                this.aCp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aCp, a.d.sdk_cp_cont_f);
            this.aCp.setText(string);
            this.aCp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
