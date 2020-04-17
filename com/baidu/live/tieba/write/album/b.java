package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private AlbumActivity aWd;
    private String aWo;
    private int aWp;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.aWd = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.aWd.getPageContext().getPageActivity());
        this.aWp = BdUtilHelper.getEquipmentWidth(this.aWd.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<AlbumData> list, String str) {
        this.mList = list;
        this.aWo = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dg */
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
            aVar.aWq = (TbImageView) view.findViewById(a.g.item_head);
            aVar.aWr = (TextView) view.findViewById(a.g.item_name);
            aVar.aWs = (ImageView) view.findViewById(a.g.item_arrow);
            aVar.aWq.setGifIconSupport(false);
            aVar.aWq.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aWr.setText(BdUtilHelper.getTextOmit(aVar.aWr.getPaint(), item.getName(), this.aWp) + "(" + item.getCount() + ")");
            } else {
                aVar.aWr.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aWo)) {
                SkinManager.setImageResource(aVar.aWs, a.f.sdk_ph_icon_list_select_ok_n);
                aVar.aWs.setVisibility(0);
            } else {
                aVar.aWs.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.aWq.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.aWq.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.aWr, a.d.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.f.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TbImageView aWq;
        TextView aWr;
        ImageView aWs;

        private a() {
        }
    }
}
