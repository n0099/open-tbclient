package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class ax extends bl {
    public static final BdUniqueId Yv = BdUniqueId.gen();
    private List<PhotoLiveCardData> Yw;
    private int Yx = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void r(List<PhotoLiveCardData> list) {
        this.Yw = list;
    }

    public void a(bl blVar, int i) {
        if (blVar != null) {
            setAuthor(blVar.getAuthor());
            setTitle(blVar.getTitle());
            setPhotoLiveCover(blVar.getPhotoLiveCover());
            cJ(blVar.rK());
            cF(blVar.getTid());
            m(blVar.rz());
            setAddress(blVar.getAddress());
            setId(blVar.getId());
            setThreadType(blVar.getThreadType());
            a(blVar.rv());
            bR(blVar.rx());
            setPost_num(blVar.getPost_num());
            cK(blVar.rN());
            cF(blVar.getTid());
            setExpressionDatas(blVar.rY());
            setShowExpressionViewIndexList(blVar.rY());
            setId(blVar.getId());
            a(blVar.qw());
            this.aaF = blVar.sb();
            this.aaG = blVar.sc();
            this.aaH = blVar.sd();
            if (getShowStyle() < 0) {
                this.Yx = getRandom(3, i);
            }
        }
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            if (zhiBoInfoTW.user != null) {
                MetaData metaData = new MetaData();
                metaData.setUserId(String.valueOf(zhiBoInfoTW.user.id));
                metaData.setUserName(zhiBoInfoTW.user.name);
                metaData.setPortrait(zhiBoInfoTW.user.portrait);
                metaData.setFansNickName(zhiBoInfoTW.user.fans_nickname);
                metaData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
                setAuthor(metaData);
            }
            cK(zhiBoInfoTW.content);
            setFid(zhiBoInfoTW.forum_id.longValue());
            setExpressionDatas(s(zhiBoInfoTW.labelInfo));
            bR(zhiBoInfoTW.reply_num.intValue());
            cJ(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            m(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(s(zhiBoInfoTW.labelInfo));
            this.Yx = getRandom(3, i);
            cF(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cJ(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> s(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                eVar.em(labelInfo.labelHot.intValue());
                eVar.setLabelId(labelInfo.labelId);
                eVar.setLabelName(labelInfo.labelContent);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public int getRandom(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    public void setShowExpressionViewIndexList(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < size && i < 3) {
            if (arrayList.get(i) != null) {
                int random = getRandom(3, -1);
                if (random == i2 || random == i3) {
                    random = k(size, i2, i3);
                }
                if (i == 0) {
                    i2 = random;
                }
                if (i == 1) {
                    i3 = random;
                }
                this.showExpressionViewIndex.add(Integer.valueOf(random));
            }
            i++;
            i2 = i2;
        }
    }

    public ArrayList<Integer> getShowExpressionViewIndex() {
        return this.showExpressionViewIndex;
    }

    private int k(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public int getShowStyle() {
        return this.Yx;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yv;
    }
}
