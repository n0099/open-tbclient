package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class aw extends bj {
    public static final BdUniqueId Xd = BdUniqueId.gen();
    private List<PhotoLiveCardData> Xe;
    private int Xf = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void m(List<PhotoLiveCardData> list) {
        this.Xe = list;
    }

    public void a(bj bjVar, int i) {
        if (bjVar != null) {
            setAuthor(bjVar.getAuthor());
            setTitle(bjVar.getTitle());
            setPhotoLiveCover(bjVar.getPhotoLiveCover());
            co(bjVar.rV());
            ci(bjVar.getTid());
            m(bjVar.rL());
            setAddress(bjVar.getAddress());
            setId(bjVar.getId());
            setThreadType(bjVar.getThreadType());
            a(bjVar.rG());
            bP(bjVar.rJ());
            setPost_num(bjVar.getPost_num());
            cp(bjVar.rY());
            ci(bjVar.getTid());
            setExpressionDatas(bjVar.sj());
            setShowExpressionViewIndexList(bjVar.sj());
            setId(bjVar.getId());
            a(bjVar.qJ());
            this.Zk = bjVar.sm();
            this.Zl = bjVar.sn();
            this.Zm = bjVar.so();
            if (getShowStyle() < 0) {
                this.Xf = getRandom(3, i);
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
            cp(zhiBoInfoTW.content);
            setFid(zhiBoInfoTW.forum_id.longValue());
            setExpressionDatas(n(zhiBoInfoTW.labelInfo));
            bP(zhiBoInfoTW.reply_num.intValue());
            co(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            m(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(n(zhiBoInfoTW.labelInfo));
            this.Xf = getRandom(3, i);
            ci(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            co(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> n(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                nVar.ee(labelInfo.labelHot.intValue());
                nVar.setLabelId(labelInfo.labelId);
                nVar.setLabelName(labelInfo.labelContent);
                arrayList.add(nVar);
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

    public void setShowExpressionViewIndexList(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
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
        return this.Xf;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xd;
    }
}
