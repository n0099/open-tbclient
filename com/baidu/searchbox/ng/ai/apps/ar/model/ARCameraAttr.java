package com.baidu.searchbox.ng.ai.apps.ar.model;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ARCameraAttr extends AiAppsNaViewModel {
    private static final String KEY_AR_KEY = "ARKey";
    private static final String KEY_AR_TYPE = "ARType";
    private static final String KEY_CAMERA_ID = "ARCameraId";
    private static final String KEY_FLASH = "flash";
    private static final String KEY_RESET = "reset";
    public String arKey;
    public String arType;
    public String cameraId;
    private String flash;
    public boolean hasReset;
    public boolean isReset;

    public ARCameraAttr(String str) {
        super(KEY_CAMERA_ID, AiAppsNAViewType.ARCAMERA);
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            AiAppsLog.e(AiAppsNAViewType.ARCAMERA, "parsing ARCameraAttr occurs exception", e);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.flash = jSONObject.optString(KEY_FLASH, FlashType.FLASH_OFF);
        this.cameraId = jSONObject.optString(KEY_CAMERA_ID);
        this.arKey = jSONObject.optString(KEY_AR_KEY);
        this.arType = jSONObject.optString(KEY_AR_TYPE);
        this.hasReset = jSONObject.has(KEY_RESET);
        this.isReset = jSONObject.optBoolean(KEY_RESET, false);
    }

    public String getFlash() {
        return FlashType.checkFlashType(this.flash);
    }

    public boolean isReset() {
        return this.isReset;
    }

    public boolean hasReset() {
        return this.hasReset;
    }

    public int getWidth() {
        return this.position.getWidth();
    }

    public int getHeight() {
        return this.position.getHeight();
    }

    /* loaded from: classes2.dex */
    public static class FlashType {
        public static final String FLASH_OFF = "off";
        public static final String FLASH_ON = "on";

        static String checkFlashType(String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3551:
                    if (str.equals(FLASH_ON)) {
                        c = 1;
                        break;
                    }
                    break;
                case 109935:
                    if (str.equals(FLASH_OFF)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    return str;
                default:
                    return FLASH_OFF;
            }
        }
    }
}
