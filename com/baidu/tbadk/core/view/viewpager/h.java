package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private int agm;
    private List<u> agt;
    private List<u> agu;
    private boolean agv;
    private boolean agw;
    private int agx = 2;
    private int agy = 1;

    public h(List<u> list, boolean z, int i) {
        this.agm = 2;
        this.agt = list;
        this.agw = z;
        this.agm = i;
        l(list);
    }

    public void l(List<u> list) {
        if (list != null && list.size() >= this.agx && list.size() <= this.agm) {
            this.agv = true;
        } else if (list.size() > this.agm && this.agw) {
            this.agv = true;
        } else {
            this.agv = false;
        }
        this.agu = wu();
    }

    private List<u> wu() {
        ArrayList arrayList = new ArrayList();
        if (this.agt != null) {
            if (this.agv) {
                if (this.agt.size() > this.agm && this.agt.size() >= this.agy) {
                    arrayList.addAll(this.agt.subList(0, this.agm));
                    arrayList.addAll(0, this.agt.subList(this.agm - this.agy, this.agm));
                    arrayList.addAll(this.agt.subList(0, this.agy));
                } else {
                    arrayList.addAll(this.agt);
                    arrayList.addAll(0, this.agt.subList(this.agt.size() - this.agy, this.agt.size()));
                    arrayList.addAll(this.agt.subList(0, this.agy));
                }
            } else if (this.agt != null && this.agt.size() > 0 && this.agt.size() >= this.agy) {
                arrayList.addAll(this.agt.subList(0, this.agy));
            }
        }
        return arrayList;
    }

    public int da(int i) {
        if (this.agv) {
            int size = this.agu.size();
            if (i == 0) {
                return (size - 1) - this.agy;
            }
            if (i == size - this.agy) {
                return this.agy;
            }
            return i;
        }
        return i;
    }

    public int db(int i) {
        if (this.agv) {
            return i - this.agy;
        }
        return i;
    }

    public int wv() {
        if (this.agt == null) {
            return 0;
        }
        return this.agt.size();
    }

    public int ww() {
        if (this.agv) {
            return this.agy;
        }
        return 0;
    }

    public void dc(int i) {
        this.agm = i;
        l(this.agt);
    }

    public void dd(int i) {
        this.agx = i;
        l(this.agt);
    }

    public List<u> wx() {
        return this.agu;
    }

    public void de(int i) {
        this.agy = i;
        l(this.agt);
    }
}
