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
    private ImageView atr;
    private TextView bdA;
    private TextView bdB;
    private c bdi;
    private AlbumActivity bdw;
    private AlbumImagePagerAdapter bdx;
    private ImageView bdy;
    private View bdz;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bdz && view == AlbumImageBrowseFragment.this.bdy && AlbumImageBrowseFragment.this.bdx != null && AlbumImageBrowseFragment.this.bdi != null && AlbumImageBrowseFragment.this.bdw != null) {
                if (AlbumImageBrowseFragment.this.bdi.Hz()) {
                    AlbumImageBrowseFragment.this.bdw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bdx.dk(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo dj = AlbumImageBrowseFragment.this.bdx.dj(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bdi.isAdded(dj)) {
                        if (AlbumImageBrowseFragment.this.bdw.b(dj)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, false);
                            AlbumImageBrowseFragment.this.bdw.a(dj, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bdw.a(dj)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, true);
                        AlbumImageBrowseFragment.this.bdw.a(dj, true);
                    }
                    AlbumImageBrowseFragment.this.Hm();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bdx != null && AlbumImageBrowseFragment.this.bdi != null) {
                ImageFileInfo dj = AlbumImageBrowseFragment.this.bdx.dj(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bdi.isAdded(dj)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, false);
                }
                if (dj == null || !dj.isGif()) {
                    AlbumImageBrowseFragment.this.bdB.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bdB.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ci(AlbumImageBrowseFragment.this.bdi.isOriginalImg());
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
        this.bdw = (AlbumActivity) getBaseFragmentActivity();
        this.bdi = this.bdw.Hj();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.atr = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.bdy = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.bdA = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.bdB = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.bdz = this.mRoot.findViewById(a.g.layout_bottom);
        this.atr.setOnClickListener(this.bdw);
        this.bdA.setOnClickListener(this.bdw);
        this.bdy.setOnClickListener(this.mOnClickListener);
        this.bdB.setOnClickListener(this.bdw);
        this.bdz.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
        this.bdw.Hg();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Ho();
        }
    }

    private void Hn() {
        List<ImageFileInfo> HE;
        int currentIndex;
        if (this.bdi == null && this.bdw != null) {
            this.bdi = this.bdw.Hj();
        }
        if (this.bdi != null && (HE = this.bdi.HE()) != null && (currentIndex = this.bdi.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bdx = new AlbumImagePagerAdapter(this.bdw);
            this.mViewPager.setAdapter(this.bdx);
            if (this.mCurrentIndex == 0 && HE != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(HE, this.mCurrentIndex);
                if (this.bdi.isAdded(imageFileInfo)) {
                    a(this.bdy, true);
                } else {
                    a(this.bdy, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bdB.setVisibility(8);
                } else {
                    this.bdB.setVisibility(0);
                }
            }
            this.bdx.setData(HE);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            ci(this.bdi.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bdx != null) {
            this.bdx.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.atr, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.bdi != null) {
            ci(this.bdi.isOriginalImg());
        }
        if (this.bdx != null) {
            this.bdx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bdw != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.bdA != null) {
                int count = this.bdi != null ? ListUtils.getCount(this.bdi.HB()) : 0;
                this.bdA.setText(this.bdw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bdi != null ? this.bdi.getMaxImagesAllowed() : 1)}));
                this.bdA.setEnabled(count > 0);
            }
        }
    }

    private void Ho() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Hn();
        }
    }

    public void ci(boolean z) {
        long j;
        if (this.bdw != null && this.bdB != null) {
            if (this.bdx != null) {
                ImageFileInfo dj = this.bdx.dj(this.mCurrentIndex);
                j = dj != null ? FileHelper.getFileSize(dj.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bdw.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bdB, a.d.sdk_cp_link_tip_a);
                this.bdB.setText(sb2);
                this.bdB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bdB, a.d.sdk_cp_cont_f);
            this.bdB.setText(string);
            this.bdB.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
