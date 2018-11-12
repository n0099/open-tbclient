package com.baidu.searchbox.ng.ai.apps.canvas.model;

import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaArc;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaBeginPath;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaBezierCurveTo;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaClearRect;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaClip;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaClosePath;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaDrawImage;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaFill;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaFillRect;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaFillText;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaFont;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaLineTo;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaMoveTo;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaQuadraticCurveTo;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaRect;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaRestore;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaRotate;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSave;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaScale;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetFillStyle;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetFontSize;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetGlobalAlpha;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetLineCap;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetLineDash;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetLineJoin;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetLineWidth;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetMiterLimit;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetShadow;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetStrokeStyle;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetTextAlign;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetTextBaseline;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetTransform;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaStroke;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaStrokeRect;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaStrokeStyle;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaStrokeText;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaTransform;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaTranslate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasDrawModel extends CanvasBasicModel {
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_DATA = "data";
    private static final String KEY_METHOD = "method";
    private static final String KEY_RESERVE = "reserve";
    private static Map<String, Class<? extends AbsDrawAction>> sDrawActionMap = new HashMap();
    private List<AbsDrawAction> mDrawActionList;
    private boolean mIsReserve;

    static {
        sDrawActionMap.put(DaSetFillStyle.ACTION_TYPE, DaSetFillStyle.class);
        sDrawActionMap.put(DaFillRect.ACTION_TYPE, DaFillRect.class);
        sDrawActionMap.put(DaSetStrokeStyle.ACTION_TYPE, DaSetStrokeStyle.class);
        sDrawActionMap.put(DaStrokeStyle.ACTION_TYPE, DaStrokeStyle.class);
        sDrawActionMap.put(DaSetLineCap.ACTION_TYPE, DaSetLineCap.class);
        sDrawActionMap.put(DaSetLineJoin.ACTION_TYPE, DaSetLineJoin.class);
        sDrawActionMap.put(DaSetLineWidth.ACTION_TYPE, DaSetLineWidth.class);
        sDrawActionMap.put(DaSetLineDash.ACTION_TYPE, DaSetLineDash.class);
        sDrawActionMap.put(DaSetMiterLimit.ACTION_TYPE, DaSetMiterLimit.class);
        sDrawActionMap.put(DaStrokeRect.ACTION_TYPE, DaStrokeRect.class);
        sDrawActionMap.put(DaMoveTo.ACTION_TYPE, DaMoveTo.class);
        sDrawActionMap.put(DaLineTo.ACTION_TYPE, DaLineTo.class);
        sDrawActionMap.put(DaStroke.ACTION_TYPE, DaStroke.class);
        sDrawActionMap.put(DaFill.ACTION_TYPE, DaFill.class);
        sDrawActionMap.put(DaBeginPath.ACTION_TYPE, DaBeginPath.class);
        sDrawActionMap.put(DaRect.ACTION_TYPE, DaRect.class);
        sDrawActionMap.put(DaClearRect.ACTION_TYPE, DaClearRect.class);
        sDrawActionMap.put(DaClosePath.ACTION_TYPE, DaClosePath.class);
        sDrawActionMap.put(DaArc.ACTION_TYPE, DaArc.class);
        sDrawActionMap.put(DaBezierCurveTo.ACTION_TYPE, DaBezierCurveTo.class);
        sDrawActionMap.put(DaQuadraticCurveTo.ACTION_TYPE, DaQuadraticCurveTo.class);
        sDrawActionMap.put("scale", DaScale.class);
        sDrawActionMap.put(DaRotate.ACTION_TYPE, DaRotate.class);
        sDrawActionMap.put(DaTranslate.ACTION_TYPE, DaTranslate.class);
        sDrawActionMap.put(DaTransform.ACTION_TYPE, DaTransform.class);
        sDrawActionMap.put(DaSetTransform.ACTION_TYPE, DaSetTransform.class);
        sDrawActionMap.put(DaFont.ACTION_TYPE, DaFont.class);
        sDrawActionMap.put(DaSetFontSize.ACTION_TYPE, DaSetFontSize.class);
        sDrawActionMap.put(DaSetTextAlign.ACTION_TYPE, DaSetTextAlign.class);
        sDrawActionMap.put(DaSetTextBaseline.ACTION_TYPE, DaSetTextBaseline.class);
        sDrawActionMap.put(DaFillText.ACTION_TYPE, DaFillText.class);
        sDrawActionMap.put(DaStrokeText.ACTION_TYPE, DaStrokeText.class);
        sDrawActionMap.put(DaClip.ACTION_TYPE, DaClip.class);
        sDrawActionMap.put(DaDrawImage.ACTION_TYPE, DaDrawImage.class);
        sDrawActionMap.put(DaSave.ACTION_TYPE, DaSave.class);
        sDrawActionMap.put(DaRestore.ACTION_TYPE, DaRestore.class);
        sDrawActionMap.put(DaSetShadow.ACTION_TYPE, DaSetShadow.class);
        sDrawActionMap.put(DaSetGlobalAlpha.ACTION_TYPE, DaSetGlobalAlpha.class);
    }

    public CanvasDrawModel(String str) {
        super(str);
        this.mDrawActionList = new ArrayList();
        this.mIsReserve = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(KEY_ACTIONS));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends AbsDrawAction> cls = sDrawActionMap.get(optString);
                if (cls != null) {
                    AbsDrawAction newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.mDrawActionList.add(newInstance);
                }
            }
            this.mIsReserve = jSONObject.optInt(KEY_RESERVE) != 0;
        } catch (Exception e) {
        }
    }

    public List<AbsDrawAction> getDrawActionList() {
        return this.mDrawActionList;
    }

    public boolean isReserve() {
        return this.mIsReserve;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return super.isValid();
    }
}
