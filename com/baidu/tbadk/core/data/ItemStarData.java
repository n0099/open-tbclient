package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
/* loaded from: classes.dex */
public class ItemStarData implements Serializable {
    public List<SingleItemStar> list;

    public void parseProto(List<HeadItem> list) {
        if (com.baidu.tbadk.core.util.w.getCount(list) != 0) {
            this.list = new ArrayList();
            for (HeadItem headItem : list) {
                if (headItem != null) {
                    SingleItemStar singleItemStar = new SingleItemStar();
                    singleItemStar.parseProto(headItem);
                    this.list.add(singleItemStar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SingleItemStar implements Serializable {
        public String content;
        public String name;
        public int type;

        public SingleItemStar() {
        }

        public void parseProto(HeadItem headItem) {
            if (headItem != null) {
                this.name = headItem.name;
                this.content = headItem.content;
                this.type = headItem.type.intValue();
            }
        }
    }
}
