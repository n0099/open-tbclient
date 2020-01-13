package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private AlbumActivity axQ;
    private String ayb;
    private int ayc;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.axQ = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.axQ.getPageContext().getPageActivity());
        this.ayc = BdUtilHelper.getEquipmentWidth(this.axQ.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<AlbumData> list, String str) {
        this.mList = list;
        this.ayb = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cB */
    public AlbumData getItem(int i) {
        return (AlbumData) ListUtils.getItem(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.mLayoutInflater.inflate(a.h.sdk_ph_album_list_item, viewGroup, false);
            aVar = new a();
            aVar.ayd = (TbImageView) view.findViewById(a.g.item_head);
            aVar.aye = (TextView) view.findViewById(a.g.item_name);
            aVar.ayf = (ImageView) view.findViewById(a.g.item_arrow);
            aVar.ayd.setGifIconSupport(false);
            aVar.ayd.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aye.setText(BdUtilHelper.getTextOmit(aVar.aye.getPaint(), item.getName(), this.ayc) + "(" + item.getCount() + ")");
            } else {
                aVar.aye.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.ayb)) {
                SkinManager.setImageResource(aVar.ayf, a.f.sdk_ph_icon_list_select_ok_n);
                aVar.ayf.setVisibility(0);
            } else {
                aVar.ayf.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.ayd.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.ayd.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.aye, a.d.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.f.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TbImageView ayd;
        TextView aye;
        ImageView ayf;

        private a() {
        }
    }
}
