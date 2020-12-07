package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private AlbumActivity bHE;
    private String bHR;
    private int bHS;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.bHE = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bHE.getPageContext().getPageActivity());
        this.bHS = BdUtilHelper.getEquipmentWidth(this.bHE.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<AlbumData> list, String str) {
        this.mList = list;
        this.bHR = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gu */
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
            view = this.mLayoutInflater.inflate(a.g.sdk_ph_album_list_item, viewGroup, false);
            aVar = new a();
            aVar.bHT = (TbImageView) view.findViewById(a.f.item_head);
            aVar.bHU = (TextView) view.findViewById(a.f.item_name);
            aVar.bHV = (ImageView) view.findViewById(a.f.item_arrow);
            aVar.bHT.setGifIconSupport(false);
            aVar.bHT.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bHU.setText(BdUtilHelper.getTextOmit(aVar.bHU.getPaint(), item.getName(), this.bHS) + "(" + item.getCount() + ")");
            } else {
                aVar.bHU.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bHR)) {
                SkinManager.setImageResource(aVar.bHV, a.e.sdk_ph_icon_list_select_ok_n);
                aVar.bHV.setVisibility(0);
            } else {
                aVar.bHV.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.bHT.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.bHT.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.bHU, a.c.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.e.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class a {
        TbImageView bHT;
        TextView bHU;
        ImageView bHV;

        private a() {
        }
    }
}
