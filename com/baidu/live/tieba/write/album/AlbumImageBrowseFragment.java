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
/* loaded from: classes7.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aBA;
    private AlbumActivity boI;
    private AlbumImagePagerAdapter boJ;
    private ImageView boK;
    private View boL;
    private TextView boM;
    private TextView boN;
    private c bou;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.boL && view == AlbumImageBrowseFragment.this.boK && AlbumImageBrowseFragment.this.boJ != null && AlbumImageBrowseFragment.this.bou != null && AlbumImageBrowseFragment.this.boI != null) {
                if (AlbumImageBrowseFragment.this.bou.OL()) {
                    AlbumImageBrowseFragment.this.boI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.boJ.fp(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fo = AlbumImageBrowseFragment.this.boJ.fo(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bou.isAdded(fo)) {
                        if (AlbumImageBrowseFragment.this.boI.b(fo)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, false);
                            AlbumImageBrowseFragment.this.boI.a(fo, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.boI.a(fo)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, true);
                        AlbumImageBrowseFragment.this.boI.a(fo, true);
                    }
                    AlbumImageBrowseFragment.this.Oy();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.boJ != null && AlbumImageBrowseFragment.this.bou != null) {
                ImageFileInfo fo = AlbumImageBrowseFragment.this.boJ.fo(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bou.isAdded(fo)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, false);
                }
                if (fo == null || !fo.isGif()) {
                    AlbumImageBrowseFragment.this.boN.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.boN.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cy(AlbumImageBrowseFragment.this.bou.isOriginalImg());
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
        this.boI = (AlbumActivity) getBaseFragmentActivity();
        this.bou = this.boI.Ov();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aBA = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.boK = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.boM = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.boN = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.boL = this.mRoot.findViewById(a.g.layout_bottom);
        this.aBA.setOnClickListener(this.boI);
        this.boM.setOnClickListener(this.boI);
        this.boK.setOnClickListener(this.mOnClickListener);
        this.boN.setOnClickListener(this.boI);
        this.boL.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        this.boI.Os();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            OA();
        }
    }

    private void Oz() {
        List<ImageFileInfo> OQ;
        int currentIndex;
        if (this.bou == null && this.boI != null) {
            this.bou = this.boI.Ov();
        }
        if (this.bou != null && (OQ = this.bou.OQ()) != null && (currentIndex = this.bou.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.boJ = new AlbumImagePagerAdapter(this.boI);
            this.mViewPager.setAdapter(this.boJ);
            if (this.mCurrentIndex == 0 && OQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(OQ, this.mCurrentIndex);
                if (this.bou.isAdded(imageFileInfo)) {
                    a(this.boK, true);
                } else {
                    a(this.boK, false);
                }
                if (imageFileInfo.isGif()) {
                    this.boN.setVisibility(8);
                } else {
                    this.boN.setVisibility(0);
                }
            }
            this.boJ.setData(OQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cy(this.bou.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.boJ != null) {
            this.boJ.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aBA, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.bou != null) {
            cy(this.bou.isOriginalImg());
        }
        if (this.boJ != null) {
            this.boJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.boI != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.boM != null) {
                int count = this.bou != null ? ListUtils.getCount(this.bou.ON()) : 0;
                this.boM.setText(this.boI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bou != null ? this.bou.getMaxImagesAllowed() : 1)}));
                this.boM.setEnabled(count > 0);
            }
        }
    }

    private void OA() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Oz();
        }
    }

    public void cy(boolean z) {
        long j;
        if (this.boI != null && this.boN != null) {
            if (this.boJ != null) {
                ImageFileInfo fo = this.boJ.fo(this.mCurrentIndex);
                j = fo != null ? FileHelper.getFileSize(fo.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.boI.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.boN, a.d.sdk_cp_link_tip_a);
                this.boN.setText(sb2);
                this.boN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.boN, a.d.sdk_cp_cont_f);
            this.boN.setText(string);
            this.boN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
