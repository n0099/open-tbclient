package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class SmallTailInfo implements Serializable {
    private static final long serialVersionUID = -6548060282571779153L;
    public String color;
    public List<SmallTailInfoContent> content;
    public int id;

    /* loaded from: classes.dex */
    public class SmallTailInfoContent implements Serializable {
        private static final long serialVersionUID = -2017172862365526905L;
        public String text;
        public int type;

        public SmallTailInfoContent(String str, int i) {
            this.text = str;
            this.type = i;
        }
    }
}
