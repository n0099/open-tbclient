package com.baidu.live.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private AlbumActivity bHE;
    private Map<Integer, Boolean> bHQ = new HashMap();
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(AlbumActivity albumActivity) {
        this.bHE = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bHE.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo gs(int i) {
        return (ImageFileInfo) ListUtils.getItem(this.mList, i);
    }

    public boolean gt(int i) {
        if (this.bHQ.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.bHQ.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(a.g.sdk_ph_album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.thumbnail_iamge);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        ImageFileInfo gs = gs(i);
        if (gs != null) {
            tbImageView.startLoad(gs.getFilePath(), 35, false, false);
            this.bHQ.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        SkinManager.setBackgroundColor(inflate, a.c.sdk_cp_bg_line_d);
        return inflate;
    }
}
