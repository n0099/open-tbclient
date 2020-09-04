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
    private ImageView aBC;
    private AlbumActivity boL;
    private AlbumImagePagerAdapter boM;
    private ImageView boN;
    private View boO;
    private TextView boP;
    private TextView boQ;
    private c box;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.boO && view == AlbumImageBrowseFragment.this.boN && AlbumImageBrowseFragment.this.boM != null && AlbumImageBrowseFragment.this.box != null && AlbumImageBrowseFragment.this.boL != null) {
                if (AlbumImageBrowseFragment.this.box.OL()) {
                    AlbumImageBrowseFragment.this.boL.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.boM.fp(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fo = AlbumImageBrowseFragment.this.boM.fo(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.box.isAdded(fo)) {
                        if (AlbumImageBrowseFragment.this.boL.b(fo)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, false);
                            AlbumImageBrowseFragment.this.boL.a(fo, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.boL.a(fo)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, true);
                        AlbumImageBrowseFragment.this.boL.a(fo, true);
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
            if (AlbumImageBrowseFragment.this.boM != null && AlbumImageBrowseFragment.this.box != null) {
                ImageFileInfo fo = AlbumImageBrowseFragment.this.boM.fo(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.box.isAdded(fo)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, false);
                }
                if (fo == null || !fo.isGif()) {
                    AlbumImageBrowseFragment.this.boQ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.boQ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cz(AlbumImageBrowseFragment.this.box.isOriginalImg());
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
        this.boL = (AlbumActivity) getBaseFragmentActivity();
        this.box = this.boL.Ov();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aBC = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.boN = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.boP = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.boQ = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.boO = this.mRoot.findViewById(a.g.layout_bottom);
        this.aBC.setOnClickListener(this.boL);
        this.boP.setOnClickListener(this.boL);
        this.boN.setOnClickListener(this.mOnClickListener);
        this.boQ.setOnClickListener(this.boL);
        this.boO.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        this.boL.Os();
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
        if (this.box == null && this.boL != null) {
            this.box = this.boL.Ov();
        }
        if (this.box != null && (OQ = this.box.OQ()) != null && (currentIndex = this.box.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.boM = new AlbumImagePagerAdapter(this.boL);
            this.mViewPager.setAdapter(this.boM);
            if (this.mCurrentIndex == 0 && OQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(OQ, this.mCurrentIndex);
                if (this.box.isAdded(imageFileInfo)) {
                    a(this.boN, true);
                } else {
                    a(this.boN, false);
                }
                if (imageFileInfo.isGif()) {
                    this.boQ.setVisibility(8);
                } else {
                    this.boQ.setVisibility(0);
                }
            }
            this.boM.setData(OQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cz(this.box.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.boM != null) {
            this.boM.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aBC, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.box != null) {
            cz(this.box.isOriginalImg());
        }
        if (this.boM != null) {
            this.boM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.boL != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.boP != null) {
                int count = this.box != null ? ListUtils.getCount(this.box.ON()) : 0;
                this.boP.setText(this.boL.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.box != null ? this.box.getMaxImagesAllowed() : 1)}));
                this.boP.setEnabled(count > 0);
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

    public void cz(boolean z) {
        long j;
        if (this.boL != null && this.boQ != null) {
            if (this.boM != null) {
                ImageFileInfo fo = this.boM.fo(this.mCurrentIndex);
                j = fo != null ? FileHelper.getFileSize(fo.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.boL.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.boQ, a.d.sdk_cp_link_tip_a);
                this.boQ.setText(sb2);
                this.boQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.boQ, a.d.sdk_cp_cont_f);
            this.boQ.setText(string);
            this.boQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
