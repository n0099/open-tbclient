package com.baidu.swan.apps.core.launchtips.scene;

import androidx.annotation.NonNull;
import com.baidu.tieba.n52;
/* loaded from: classes4.dex */
public enum SceneType {
    SCENE_PMS_TIMEOUT("pms_getPkg", "PMS获取包接口返回超过3秒；"),
    SCENE_DOWNLOAD_PKG_TIMEOUT("pms_downloadPkg", "包下载进度更新间隔超2秒；"),
    SCENE_SKELETON_TIMEOUT("skeleton", "5秒内未触发骨架屏移除；"),
    SCENE_WHITE_SCREEN_L1("whiteScreen_L1", "检测到纯白屏；"),
    SCENE_WHITE_SCREEN_L2("whiteScreen_L2", n52.a),
    SCENE_WHITE_SCREEN_L3("whiteScreen_L3", n52.b),
    SCENE_INIT_DATA_ERROR("data_init", "业务数据初始化异常；"),
    SCENE_SKELETON_DEV_TIMEOUT("skeleton_dev", "开发者骨架屏异常；");
    
    public final String scene;
    public final String type;

    SceneType(@NonNull String str, @NonNull String str2) {
        this.type = str;
        this.scene = str2;
    }

    public String getScene() {
        return this.scene;
    }

    public String getType() {
        return this.type;
    }
}
