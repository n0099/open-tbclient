package com.baidu.searchbox.ng.ai.apps.camera.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CameraAttrModel extends AiAppsNaViewModel {
    private static final String KEY_CAMERA_ID = "cameraId";
    private static final String KEY_DEVICE_POSITION = "devicePosition";
    private static final String KEY_FLASH = "flash";
    public String cameraId;
    private String devicePosition;
    private String flash;

    public CameraAttrModel(String str) {
        super(KEY_CAMERA_ID, "camera");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            AiAppsLog.e("Camera", "parsing CameraAttrModel occurs exception", e);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.devicePosition = jSONObject.optString(KEY_DEVICE_POSITION, AiAppsUBCStatistic.VALUE_BACK);
        this.flash = jSONObject.optString(KEY_FLASH, "auto");
        this.cameraId = jSONObject.optString(KEY_CAMERA_ID);
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.devicePosition, "front");
    }

    public String getFlash() {
        return FlashType.checkFlashType(this.flash);
    }

    public int getWidth() {
        return this.position.getWidth();
    }

    public int getHeight() {
        return this.position.getHeight();
    }

    /* loaded from: classes2.dex */
    private static class FlashType {
        private static final String FLASH_AUTO = "auto";
        private static final String FLASH_OFF = "off";
        private static final String FLASH_ON = "on";

        private FlashType() {
        }

        static String checkFlashType(String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3551:
                    if (str.equals("on")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109935:
                    if (str.equals("off")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals(FLASH_AUTO)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    return str;
                default:
                    return FLASH_AUTO;
            }
        }
    }
}
