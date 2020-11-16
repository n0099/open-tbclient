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
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bCz && view == AlbumImageBrowseFragment.this.bCy && AlbumImageBrowseFragment.this.bCx != null && AlbumImageBrowseFragment.this.bCi != null && AlbumImageBrowseFragment.this.bCw != null) {
                if (AlbumImageBrowseFragment.this.bCi.Tn()) {
                    AlbumImageBrowseFragment.this.bCw.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bCx.fU(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fT = AlbumImageBrowseFragment.this.bCx.fT(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bCi.isAdded(fT)) {
                        if (AlbumImageBrowseFragment.this.bCw.b(fT)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, false);
                            AlbumImageBrowseFragment.this.bCw.a(fT, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bCw.a(fT)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, true);
                        AlbumImageBrowseFragment.this.bCw.a(fT, true);
                    }
                    AlbumImageBrowseFragment.this.Ta();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bCx != null && AlbumImageBrowseFragment.this.bCi != null) {
                ImageFileInfo fT = AlbumImageBrowseFragment.this.bCx.fT(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bCi.isAdded(fT)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, false);
                }
                if (fT == null || !fT.isGif()) {
                    AlbumImageBrowseFragment.this.bCB.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bCB.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cS(AlbumImageBrowseFragment.this.bCi.isOriginalImg());
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
        this.bCw = (AlbumActivity) getBaseFragmentActivity();
        this.bCi = this.bCw.SX();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
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
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        this.bCw.SU();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Tc();
        }
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

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bCx != null) {
            this.bCx.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
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

    private void Tc() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Tb();
        }
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
