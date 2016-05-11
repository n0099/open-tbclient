package com.baidu.tbadk.core.data;

import android.graphics.Color;
import android.text.SpannableString;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.t;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class SmallTailInfo implements Serializable {
    private static final long serialVersionUID = -6548060282571779153L;
    public String color;
    public List<SmallTailInfoContent> content;
    public int id;
    public int showColorId;
    public transient SpannableString tailSpannable;

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

    public void updateShowInfo() {
        qt();
        qu();
    }

    private void qt() {
        if (this.content != null) {
            StringBuilder sb = new StringBuilder();
            for (SmallTailInfoContent smallTailInfoContent : this.content) {
                if (smallTailInfoContent.type == 0) {
                    if (smallTailInfoContent.text != null) {
                        sb.append(smallTailInfoContent.text);
                    }
                } else if (smallTailInfoContent.type == 2 && !StringUtils.isNull(smallTailInfoContent.text)) {
                    String fk = TbFaceManager.CG().fk(smallTailInfoContent.text);
                    if (!StringUtils.isNull(fk)) {
                        sb.append("#(" + fk + ")");
                    }
                }
            }
            this.tailSpannable = TbFaceManager.CG().a(TbadkCoreApplication.m11getInst(), sb.toString(), null);
        }
    }

    private void qu() {
        try {
            this.showColorId = Color.parseColor(co(this.color));
        } catch (Exception e) {
            this.showColorId = Color.parseColor(co(TbadkCoreApplication.m11getInst().getString(t.j.tail_color_default)));
        }
    }

    private String co(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
            return String.valueOf(TbadkCoreApplication.m11getInst().getString(t.j.color_prefix)) + TbadkCoreApplication.m11getInst().getString(t.j.tail_color_night) + str;
        }
        return String.valueOf(TbadkCoreApplication.m11getInst().getString(t.j.color_prefix)) + str;
    }
}
