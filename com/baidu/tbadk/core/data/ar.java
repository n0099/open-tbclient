package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class ar extends bd {
    public static final BdUniqueId aMu = BdUniqueId.gen();
    private List<PhotoLiveCardData> aMv;
    private int aMw = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void B(List<PhotoLiveCardData> list) {
        this.aMv = list;
    }

    public void a(bd bdVar, int i) {
        if (bdVar != null) {
            a(bdVar.yS());
            setTitle(bdVar.getTitle());
            setPhotoLiveCover(bdVar.getPhotoLiveCover());
            cO(bdVar.yY());
            cK(bdVar.getTid());
            v(bdVar.yM());
            setAddress(bdVar.getAddress());
            setId(bdVar.getId());
            setThreadType(bdVar.getThreadType());
            a(bdVar.yH());
            eP(bdVar.yK());
            setPost_num(bdVar.getPost_num());
            cP(bdVar.getAbstract());
            cK(bdVar.getTid());
            setExpressionDatas(bdVar.zm());
            setShowExpressionViewIndexList(bdVar.zm());
            setId(bdVar.getId());
            a(bdVar.xL());
            this.aOD = bdVar.zp();
            this.aOE = bdVar.zq();
            this.aOF = bdVar.zr();
            if (getShowStyle() < 0) {
                this.aMw = getRandom(3, i);
            }
        }
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
        return this.aMw;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMu;
    }
}
