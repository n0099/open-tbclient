package com.baidu.tbadk.core.data;

import android.graphics.Color;
import android.text.SpannableString;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.e;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class SmallTailInfo extends OrmObject implements Serializable {
    private static final long serialVersionUID = -6548060282571779153L;
    public String color;
    public List<SmallTailInfoContent> content;
    public int id;
    public int showColorId;
    public transient SpannableString tailSpannable;

    /* loaded from: classes.dex */
    public class SmallTailInfoContent extends OrmObject implements Serializable {
        private static final long serialVersionUID = -2017172862365526905L;
        public String text;
        public int type;

        public SmallTailInfoContent() {
        }

        public SmallTailInfoContent(String str, int i) {
            this.text = str;
            this.type = i;
        }
    }

    public void updateShowInfo() {
        yb();
        yc();
    }

    private void yb() {
        if (this.content != null) {
            StringBuilder sb = new StringBuilder();
            for (SmallTailInfoContent smallTailInfoContent : this.content) {
                if (smallTailInfoContent.type == 0) {
                    if (smallTailInfoContent.text != null) {
                        sb.append(smallTailInfoContent.text);
                    }
                } else if (smallTailInfoContent.type == 2 && !StringUtils.isNull(smallTailInfoContent.text)) {
                    String hn = TbFaceManager.Mp().hn(smallTailInfoContent.text);
                    if (!StringUtils.isNull(hn)) {
                        sb.append("#(" + hn + ")");
                    }
                }
            }
            this.tailSpannable = TbFaceManager.Mp().a(TbadkCoreApplication.getInst(), sb.toString(), null);
        }
    }

    private void yc() {
        try {
            this.showColorId = Color.parseColor(dQ(this.color));
        } catch (Exception e) {
            this.showColorId = Color.parseColor(dQ(TbadkCoreApplication.getInst().getString(e.j.tail_color_default)));
        }
    }

    private String dQ(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return TbadkCoreApplication.getInst().getString(e.j.color_prefix) + TbadkCoreApplication.getInst().getString(e.j.tail_color_night) + str;
        }
        return TbadkCoreApplication.getInst().getString(e.j.color_prefix) + str;
    }
}
