package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
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
public class h {
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
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bdz && view == h.this.bdy && h.this.bdx != null && h.this.bdi != null && h.this.bdw != null) {
                if (h.this.bdi.Hz()) {
                    h.this.bdw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bdx.dk(h.this.mCurrentIndex)) {
                    ImageFileInfo dj = h.this.bdx.dj(h.this.mCurrentIndex);
                    if (h.this.bdi.isAdded(dj)) {
                        if (h.this.bdw.b(dj)) {
                            h.this.a(h.this.bdy, false);
                            h.this.bdw.a(dj, false);
                        }
                    } else if (h.this.bdw.a(dj)) {
                        h.this.a(h.this.bdy, true);
                        h.this.bdw.a(dj, true);
                    }
                    h.this.Hm();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.bdx != null && h.this.bdi != null) {
                ImageFileInfo dj = h.this.bdx.dj(h.this.mCurrentIndex);
                if (h.this.bdi.isAdded(dj)) {
                    h.this.a(h.this.bdy, true);
                } else {
                    h.this.a(h.this.bdy, false);
                }
                if (dj == null || !dj.isGif()) {
                    h.this.bdB.setVisibility(0);
                } else {
                    h.this.bdB.setVisibility(8);
                }
                h.this.ci(h.this.bdi.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public h(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.bdw = albumActivity;
        this.bdi = this.bdw.Hj();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bdw).inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
        this.bdw.Hg();
    }

    public void onResume() {
        Ho();
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

    public View getView() {
        return this.mRoot;
    }

    public View HI() {
        return this.atr;
    }

    public View HJ() {
        return this.bdA;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
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

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo dj;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bdx != null && (dj = this.bdx.dj(this.mCurrentIndex)) != null && dj.getFilePath() != null && dj.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bdy, z);
        }
    }

    private void Ho() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        Hn();
    }

    public View Hu() {
        return this.bdB;
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
