package com.baidu.ala.gift;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class AlaDynamicGiftLocalInfoConfig {
    public static final String DIR_NAME = ".dynamic";
    public static final String DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + DIR_NAME + "/";
    public static final String PIC_MD5_PREFIX = "pic_md5_list_";
}
