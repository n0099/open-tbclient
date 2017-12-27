package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class as extends be {
    public static final BdUniqueId aMy = BdUniqueId.gen();
    private List<PhotoLiveCardData> aMz;
    private int aMA = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void C(List<PhotoLiveCardData> list) {
        this.aMz = list;
    }

    public void a(be beVar, int i) {
        if (beVar != null) {
            a(beVar.yX());
            setTitle(beVar.getTitle());
            setPhotoLiveCover(beVar.getPhotoLiveCover());
            cO(beVar.zd());
            cK(beVar.getTid());
            v(beVar.yR());
            setAddress(beVar.getAddress());
            setId(beVar.getId());
            setThreadType(beVar.getThreadType());
            a(beVar.yM());
            eQ(beVar.yP());
            setPost_num(beVar.getPost_num());
            cP(beVar.getAbstract());
            cK(beVar.getTid());
            setExpressionDatas(beVar.zr());
            setShowExpressionViewIndexList(beVar.zr());
            setId(beVar.getId());
            a(beVar.xO());
            this.aOF = beVar.zu();
            this.aOG = beVar.zv();
            this.aOH = beVar.zw();
            if (getShowStyle() < 0) {
                this.aMA = getRandom(3, i);
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
                a(metaData);
            }
            cP(zhiBoInfoTW.content);
            setFid(zhiBoInfoTW.forum_id.longValue());
            setExpressionDatas(D(zhiBoInfoTW.labelInfo));
            eQ(zhiBoInfoTW.reply_num.intValue());
            cO(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            v(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(D(zhiBoInfoTW.labelInfo));
            this.aMA = getRandom(3, i);
            cK(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cO(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> D(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                eVar.ht(labelInfo.labelHot.intValue());
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
                    random = s(size, i2, i3);
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

    private int s(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public int getShowStyle() {
        return this.aMA;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMy;
    }
}
