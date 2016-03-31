package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GraffitiPaintActivityConfig extends IntentConfig {
    public static final String GRAFFITO_FILE_NAME = "graffiti_file_name";

    public GraffitiPaintActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("user_id", TbadkCoreApplication.getCurrentAccount());
        getIntent().putExtra("from", i);
    }

    public GraffitiPaintActivityConfig(Context context, String str, int i) {
        super(context);
        if (!StringUtils.isNull(str)) {
            getIntent().putExtra(GRAFFITO_FILE_NAME, str);
        }
        getIntent().putExtra("user_id", TbadkCoreApplication.getCurrentAccount());
        getIntent().putExtra("from", i);
    }
}
