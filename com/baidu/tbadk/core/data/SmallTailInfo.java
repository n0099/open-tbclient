package com.baidu.tbadk.core.data;

import android.graphics.Color;
import android.text.SpannableString;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class SmallTailInfo extends OrmObject implements Serializable {
    public static final String EMOTION_PREFIX = "#(";
    public static final String EMOTION_SUFFIX = ")";
    public static final int TAIL_CONTENT_TYPE_EMOTION = 2;
    public static final int TAIL_CONTENT_TYPE_TEXT = 0;
    public static final long serialVersionUID = -6548060282571779153L;
    public String color;
    public List<SmallTailInfoContent> content;
    public int id;
    public int showColorId;
    public transient SpannableString tailSpannable;

    /* loaded from: classes3.dex */
    public class SmallTailInfoContent extends OrmObject implements Serializable {
        public static final long serialVersionUID = -2017172862365526905L;
        public String text;
        public int type;

        public SmallTailInfoContent() {
        }

        public SmallTailInfoContent(String str, int i2) {
            this.text = str;
            this.type = i2;
        }
    }

    private String getShowColorText(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + TbadkCoreApplication.getInst().getString(R.string.tail_color_night) + str;
        }
        return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + str;
    }

    private void updateColor() {
        try {
            this.showColorId = Color.parseColor(getShowColorText(this.color));
        } catch (Exception unused) {
            this.showColorId = Color.parseColor(getShowColorText(TbadkCoreApplication.getInst().getString(R.string.tail_color_default)));
        }
    }

    private void updateTailSpannable() {
        if (this.content == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (SmallTailInfoContent smallTailInfoContent : this.content) {
            int i2 = smallTailInfoContent.type;
            if (i2 == 0) {
                String str = smallTailInfoContent.text;
                if (str != null) {
                    sb.append(str);
                }
            } else if (i2 == 2 && !StringUtils.isNull(smallTailInfoContent.text)) {
                String f2 = TbFaceManager.e().f(smallTailInfoContent.text);
                if (!StringUtils.isNull(f2)) {
                    sb.append(EMOTION_PREFIX + f2 + EMOTION_SUFFIX);
                }
            }
        }
        this.tailSpannable = TbFaceManager.e().l(TbadkCoreApplication.getInst(), sb.toString(), null);
    }

    public void updateShowInfo() {
        updateTailSpannable();
        updateColor();
    }
}
