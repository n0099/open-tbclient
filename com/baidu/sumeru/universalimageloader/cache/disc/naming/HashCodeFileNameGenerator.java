package com.baidu.sumeru.universalimageloader.cache.disc.naming;
/* loaded from: classes12.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
