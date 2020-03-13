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
    private c aBU;
    private AlbumActivity aCi;
    private AlbumImagePagerAdapter aCm;
    private ImageView aCn;
    private View aCo;
    private TextView aCp;
    private TextView aCq;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCo && view == AlbumImageBrowseFragment.this.aCn && AlbumImageBrowseFragment.this.aCm != null && AlbumImageBrowseFragment.this.aBU != null && AlbumImageBrowseFragment.this.aCi != null) {
                if (AlbumImageBrowseFragment.this.aBU.AE()) {
                    AlbumImageBrowseFragment.this.aCi.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aCm.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cP = AlbumImageBrowseFragment.this.aCm.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aBU.isAdded(cP)) {
                        if (AlbumImageBrowseFragment.this.aCi.b(cP)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, false);
                            AlbumImageBrowseFragment.this.aCi.a(cP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aCi.a(cP)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, true);
                        AlbumImageBrowseFragment.this.aCi.a(cP, true);
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
            if (AlbumImageBrowseFragment.this.aCm != null && AlbumImageBrowseFragment.this.aBU != null) {
                ImageFileInfo cP = AlbumImageBrowseFragment.this.aCm.cP(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aBU.isAdded(cP)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, false);
                }
                if (cP == null || !cP.isGif()) {
                    AlbumImageBrowseFragment.this.aCq.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCq.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.aBU.isOriginalImg());
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
        this.aCi = (AlbumActivity) getBaseFragmentActivity();
        this.aBU = this.aCi.Ao();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aCn = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aCp = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aCq = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aCo = this.mRoot.findViewById(a.g.layout_bottom);
        this.Wg.setOnClickListener(this.aCi);
        this.aCp.setOnClickListener(this.aCi);
        this.aCn.setOnClickListener(this.mOnClickListener);
        this.aCq.setOnClickListener(this.aCi);
        this.aCo.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        this.aCi.Al();
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
        if (this.aBU == null && this.aCi != null) {
            this.aBU = this.aCi.Ao();
        }
        if (this.aBU != null && (AJ = this.aBU.AJ()) != null && (currentIndex = this.aBU.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aCm = new AlbumImagePagerAdapter(this.aCi);
            this.mViewPager.setAdapter(this.aCm);
            if (this.mCurrentIndex == 0 && AJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(AJ, this.mCurrentIndex);
                if (this.aBU.isAdded(imageFileInfo)) {
                    a(this.aCn, true);
                } else {
                    a(this.aCn, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aCq.setVisibility(8);
                } else {
                    this.aCq.setVisibility(0);
                }
            }
            this.aCm.setData(AJ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.aBU.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aCm != null) {
            this.aCm.setData(null);
        }
    }

    public View AA() {
        return this.Wg;
    }

    public View AB() {
        return this.aCp;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Wg, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aBU != null) {
            bt(this.aBU.isOriginalImg());
        }
        if (this.aCm != null) {
            this.aCm.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aCi != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aCp != null) {
                int count = this.aBU != null ? ListUtils.getCount(this.aBU.AG()) : 0;
                this.aCp.setText(this.aCi.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aBU != null ? this.aBU.getMaxImagesAllowed() : 1)}));
                this.aCp.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aCm != null && (cP = this.aCm.cP(this.mCurrentIndex)) != null && cP.getFilePath() != null && cP.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCn, z);
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
        return this.aCq;
    }

    public void bt(boolean z) {
        long j;
        if (this.aCi != null && this.aCq != null) {
            if (this.aCm != null) {
                ImageFileInfo cP = this.aCm.cP(this.mCurrentIndex);
                j = cP != null ? FileHelper.getFileSize(cP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aCi.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aCq, a.d.sdk_cp_link_tip_a);
                this.aCq.setText(sb2);
                this.aCq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aCq, a.d.sdk_cp_cont_f);
            this.aCq.setText(string);
            this.aCq.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
