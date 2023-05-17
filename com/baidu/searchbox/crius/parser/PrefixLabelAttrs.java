package com.baidu.searchbox.crius.parser;

import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.util.CriusUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PrefixLabelAttrs {
    public static final int HAS_PREFIX_VALUE = 1;
    public String bindingId;
    public boolean hasPrefix;
    public double prefixTitleMargin;
    public double prefixWidthWithoutText;

    public static PrefixLabelAttrs getLabelAttrs(JSONObject jSONObject) {
        PrefixLabelAttrs prefixLabelAttrs = new PrefixLabelAttrs();
        boolean z = true;
        if (jSONObject.optInt(NativeConstants.HAS_PREFIX) != 1) {
            z = false;
        }
        prefixLabelAttrs.hasPrefix = z;
        prefixLabelAttrs.prefixTitleMargin = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.PREFIX_MARGIN);
        prefixLabelAttrs.bindingId = jSONObject.optString(NativeConstants.BINDING_ID);
        prefixLabelAttrs.prefixWidthWithoutText = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.PREFIX_WIDTH_WITHOUT_TEXT);
        return prefixLabelAttrs;
    }
}
